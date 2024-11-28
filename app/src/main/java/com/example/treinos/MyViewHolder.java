package com.example.treinos;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView item_name;
    ImageButton ib_excluir;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        item_name = itemView.findViewById(R.id.item_name);
        ib_excluir = itemView.findViewById(R.id.ib_excluir);




    }
}
