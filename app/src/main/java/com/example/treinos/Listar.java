package com.example.treinos;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Listar extends AppCompatActivity {

    RecyclerView rv_listar;
    Button bt_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listar);

        rv_listar = findViewById(R.id.rv_listar);
        bt_voltar = findViewById(R.id.bt_voltar);

        MovimentoDAO dao = new MovimentoDAO(Listar.this);

        List<Movimento> movimentoList = dao.exibirDados();

        Adapter adapter = new Adapter(Listar.this, movimentoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Listar.this, LinearLayoutManager.VERTICAL, false);
        rv_listar.setLayoutManager(layoutManager);

        rv_listar.setAdapter(adapter);
        adapter.setMov(movimentoList);

        adapter.notifyDataSetChanged();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}