package com.example.prova190126.ui;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.prova190126.data.Personagem;
import com.example.prova190126.repository.PersonagemRepository;
import java.util.List;

public class DadosViewModel extends AndroidViewModel {

    private final PersonagemRepository repository;
    private final MutableLiveData<List<Personagem>> listaPersonagens = new MutableLiveData<>();
    private final MutableLiveData<String> mensagemErro = new MutableLiveData<>();
    private final MutableLiveData<String> mensagemSucesso = new MutableLiveData<>();

    public DadosViewModel(@NonNull Application application) {
        super(application);
        this.repository = new PersonagemRepository(application);
    }

    public LiveData<List<Personagem>> getListaPersonagens() {
        return listaPersonagens;
    }

    public LiveData<String> getMensagemErro() {
        return mensagemErro;
    }

    public LiveData<String> getMensagemSucesso() {
        return mensagemSucesso;
    }

    public void baixarDados() {
        repository.baixarESalvarDados(new PersonagemRepository.DadosCallback() {
            @Override
            public void onSucesso() {
                mensagemSucesso.postValue("Dados baixados! Carregando lista...");
                carregarTodos();
            }

            @Override
            public void onErro(String mensagem) {
                mensagemErro.postValue(mensagem);
            }
        });
    }

    public void carregarLista(int n) {
        repository.buscarSublistaLocal(n, new PersonagemRepository.ListaCallback() {
            @Override
            public void onResultado(List<Personagem> lista) {
                if (lista != null) {
                    listaPersonagens.postValue(lista);
                } else {
                    mensagemErro.postValue("Número inválido ou maior que o total disponível.");
                }
            }
        });
    }

    public void carregarTodos() {
        repository.buscarTodosLocal(new PersonagemRepository.ListaCallback() {
            @Override
            public void onResultado(List<Personagem> lista) {
                listaPersonagens.postValue(lista);
            }
        });
    }
}