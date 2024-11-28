package com.example.treinos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Detalhe extends AppCompatActivity {

    TextView tv_nome, tv_tipo, tv_descricao1;
    Button  bt_voltar3;
    VideoView v_video;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhe);

      // tv_id_detalhe = findViewById(R.id.tv_id_detalhe);
        tv_nome = findViewById(R.id.tv_nome);
        tv_tipo = findViewById(R.id.tv_tipo);
        tv_descricao1 = findViewById(R.id.tv_descricao1);
        v_video = findViewById(R.id.v_video);
        bt_voltar3 = findViewById(R.id.bt_voltar3);

        Intent intent = getIntent();
        int movID = intent.getIntExtra("movimento", 0);

        MovimentoDAO dao;
        dao = new MovimentoDAO(Detalhe.this);

        Movimento m = dao.consultarPorId(movID);

      // tv_id_detalhe.setText(m.getId());
        tv_nome.setText("Movimento: " + m.getNome());
        tv_tipo.setText("Tipo: " + m.getTipo());
        tv_descricao1.setText("Descrição: " + m.getDescricao());
        //v_video.



        bt_voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        voltarTela();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void voltarTela() {
        Intent telaPrincipal = new Intent(Detalhe.this, Listar.class);
        startActivity(telaPrincipal);
        finish();
    }

}