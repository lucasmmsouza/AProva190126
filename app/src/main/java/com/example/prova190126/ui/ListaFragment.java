package com.example.prova190126.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prova190126.R;
import com.example.prova190126.data.Personagem;
import java.util.List;

public class ListaFragment extends Fragment {

    private DadosViewModel viewModel;
    private PersonagemAdapter adapter;
    private EditText edtQuantidade;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista, container, false);

        viewModel = new ViewModelProvider(this).get(DadosViewModel.class);
        adapter = new PersonagemAdapter();

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        edtQuantidade = root.findViewById(R.id.edtQuantidade);
        Button btnListar = root.findViewById(R.id.btnListar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = edtQuantidade.getText().toString();
                if (!texto.isEmpty()) {
                    int n = Integer.parseInt(texto);
                    viewModel.carregarLista(n);
                } else {
                    Toast.makeText(getContext(), "Informe um valor para N", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getListaPersonagens().observe(getViewLifecycleOwner(), new Observer<List<Personagem>>() {
            @Override
            public void onChanged(List<Personagem> personagems) {
                adapter.setLista(personagems);
            }
        });

        viewModel.getMensagemErro().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}