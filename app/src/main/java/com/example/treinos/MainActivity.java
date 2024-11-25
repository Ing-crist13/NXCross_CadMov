package com.example.treinos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button bt_cadastrar, bt_listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bt_cadastrar = findViewById(R.id.bt_cadastrar);
        bt_listar = findViewById(R.id.bt_listar);


        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exibirProxima();
            }
        });

        bt_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exibirProxima(0);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Inicial), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void exibirProxima() {
        Intent telaPrincipal = new Intent(MainActivity.this, Cadastrar_mov.class);
        startActivity(telaPrincipal);
        finish();
    }

    private void exibirProxima(int x) {
        Intent telaPrincipal = new Intent(MainActivity.this, Listar.class);
        startActivity(telaPrincipal);
        finish();
    }
}