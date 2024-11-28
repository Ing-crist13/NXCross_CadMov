package com.example.treinos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Movimento> mov;
    MovimentoDAO dao;


    public Adapter(Context context, List<Movimento> mov) {
        this.context = context;
        this.mov = mov;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Movimento> getMov() {
        return mov;
    }

    public void setMov(List<Movimento> mov) {
        this.mov = mov;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movimento movimento = mov.get(position);
        holder.item_name.setText(movimento.getNome());

        holder.item_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = holder.getAdapterPosition(); // associa a variavel a posiçao do clique
                Intent intent = new Intent(context, Detalhe.class);
                intent.putExtra("movimento", movimento.getId()); // passa os dados para a proxima tela (detalhe)
                context.startActivity(intent);//inicia a intent
            }
        });

        holder.ib_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperando o id do item
                int id = mov.get(position).getId();

                //Acessando o banco de dados local do aplicativo
                dao = new MovimentoDAO(context);
                //excluindo do banco de dados
                dao.excluirItem(id);
                //Remover o item também da nossa lista
                mov.remove(position);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mov.size());

                Toast.makeText(context, "Movimento excluido com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mov.size();
    }

    }

