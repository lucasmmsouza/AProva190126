package com.example.prova190126.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class DadosFragment extends Fragment {

    private DadosViewModel viewModel;
    private PersonagemAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dados, container, false);

        viewModel = new ViewModelProvider(this).get(DadosViewModel.class);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerDados);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PersonagemAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.baixarDados();


        viewModel.getListaPersonagens().observe(getViewLifecycleOwner(), new Observer<List<Personagem>>() {
            @Override
            public void onChanged(List<Personagem> personagems) {
                if (personagems != null) {
                    adapter.setLista(personagems);
                }
            }
        });

        viewModel.getMensagemSucesso().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getMensagemErro().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}