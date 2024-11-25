package com.example.treinos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Movimento> mov;

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

                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, Detalhe.class);
                intent.putExtra("movimento", movimento.getId());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return mov.size();
    }
}
