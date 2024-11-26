package com.example.treinos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView item_name;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        item_name = itemView.findViewById(R.id.item_name);




    }
}
