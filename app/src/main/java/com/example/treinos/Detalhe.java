package com.example.treinos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Detalhe extends AppCompatActivity {

    TextView tv_nome, tv_tipo, tv_descricao1;
    Button bt_excluir, bt_voltar3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhe);

        tv_nome = findViewById(R.id.tv_nome);
        tv_tipo = findViewById(R.id.tv_tipo);
        tv_descricao1 = findViewById(R.id.tv_descricao1);
        bt_excluir = findViewById(R.id.bt_excluir);
        bt_voltar3 = findViewById(R.id.bt_voltar3);

        Intent intent = getIntent();
        int movID = intent.getIntExtra("movimento", 0);

        MovimentoDAO dao;
        dao = new MovimentoDAO(Detalhe.this);

        Movimento m = dao.consultarPorId(movID);

        tv_nome.setText("Movimento: " + m.getNome());
        tv_tipo.setText("Tipo: " + m.getTipo());
        tv_descricao1.setText("Descrição: " + m.getDescricao());



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}