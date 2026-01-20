
package com.example.prova190126.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.prova190126.R;
import com.example.prova190126.data.Personagem;
import java.util.ArrayList;
import java.util.List;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.ViewHolder> {

    private List<Personagem> lista = new ArrayList<>();

    public void setLista(List<Personagem> novaLista) {
        this.lista = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personagem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personagem p = lista.get(position);
        holder.txtId.setText("ID: " + p.getId());
        holder.txtNome.setText(p.getNome());

        Glide.with(holder.itemView.getContext())
                .load(p.getUrlImagem())
                .circleCrop()
                .into(holder.imgPersonagem);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPersonagem;
        TextView txtId;
        TextView txtNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPersonagem = itemView.findViewById(R.id.imgPersonagem);
            txtId = itemView.findViewById(R.id.txtId);
            txtNome = itemView.findViewById(R.id.txtNome);
        }
    }
}

