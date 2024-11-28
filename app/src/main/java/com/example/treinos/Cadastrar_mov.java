package com.example.treinos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastrar_mov extends AppCompatActivity {

    TextView tv_id;
    EditText ed_nome, ed_tipo, ed_descricao;
    Button bt_salvar, bt_voltar2, bt_carregar ;
    VideoView v_video1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_mov);



        tv_id = findViewById(R.id.tv_id);
        ed_nome = findViewById(R.id.ed_nome);
        ed_tipo = findViewById(R.id.ed_tipo);
        ed_descricao = findViewById(R.id.ed_descricao);
        v_video1 = findViewById(R.id.v_video1);
        bt_salvar = findViewById(R.id.bt_salvar);
        bt_voltar2 = findViewById(R.id.bt_voltar2);
        bt_carregar = findViewById(R.id.bt_carregar);


        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movimento m;
                m = new Movimento();

                m.setNome(ed_nome.getText().toString());
                m.setTipo(ed_tipo.getText().toString());
                m.setDescricao(ed_descricao.getText().toString());

                MovimentoDAO dao;
                dao = new MovimentoDAO(Cadastrar_mov.this);
                dao.salvarMovimento(m);

                Toast.makeText(Cadastrar_mov.this, "Movimento cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                limparCampos();

            }
        });

        bt_voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTela();

            }
        }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void limparCampos() {
        tv_id.setText("");
        ed_nome.setText("");
        ed_tipo.setText("");
        ed_descricao.setText("");
        //ed_video.setText("");
    }

    private void voltarTela() {
        Intent telaPrincipal = new Intent(Cadastrar_mov.this, MainActivity.class);
        startActivity(telaPrincipal);
        finish();
    }

}