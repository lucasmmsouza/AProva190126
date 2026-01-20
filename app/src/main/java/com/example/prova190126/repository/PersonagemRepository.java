package com.example.prova190126.repository;

import android.content.Context;
import com.example.prova190126.data.AppDatabase;
import com.example.prova190126.data.DisneyResponse;
import com.example.prova190126.data.Personagem;
import com.example.prova190126.data.PersonagemDao;
import com.example.prova190126.util.Conexao;
import com.example.prova190126.util.Conversao;
import com.google.gson.Gson;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PersonagemRepository {

    private final PersonagemDao dao;
    private final Executor executor;
    private final Conexao conexao;
    private final Conversao conversao;
    private final Gson gson;

    public PersonagemRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        this.dao = db.personagemDao();
        this.executor = Executors.newSingleThreadExecutor();
        this.conexao = new Conexao();
        this.conversao = new Conversao();
        this.gson = new Gson();
    }

    public interface DadosCallback {
        void onSucesso();
        void onErro(String mensagem);
    }

    public interface ListaCallback {
        void onResultado(List<Personagem> lista);
    }

    public void baixarESalvarDados(final DadosCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream is = conexao.obterRespostaHTTP("https://raw.githubusercontent.com/lucasmmsouza/prova190126/refs/heads/master/dados.json");

                    if (is != null) {
                        String jsonString = conversao.converter(is);

                        if (jsonString != null && !jsonString.isEmpty()) {
                            DisneyResponse response = gson.fromJson(jsonString, DisneyResponse.class);

                            if (response != null && response.getData() != null) {
                                dao.inserirTodos(response.getData());
                                callback.onSucesso();
                            } else {
                                callback.onErro("Erro ao processar dados da API.");
                            }
                        } else {
                            callback.onErro("Resposta da API vazia.");
                        }
                    } else {
                        callback.onErro("Falha na conexão com a API.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onErro("Erro: " + e.getMessage());
                }
            }
        });
    }

    public void buscarSublistaLocal(final int quantidade, final ListaCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int total = dao.contarPersonagens();
                if (quantidade > 0) {
                    if (quantidade <= total) {
                        List<Personagem> resultado = dao.obterPersonagens(quantidade);
                        callback.onResultado(resultado);
                    } else {
                        callback.onResultado(null);
                    }
                } else {
                    callback.onResultado(null);
                }
            }
        });
    }


    public void buscarTodosLocal(final ListaCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Personagem> lista = dao.obterTodos();
                callback.onResultado(lista);
            }
        });
    }


}