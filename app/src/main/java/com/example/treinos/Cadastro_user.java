package com.example.treinos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro_user extends AppCompatActivity {

    Button bt_salvar_user, bt_foto, bt_voltar_user;
    ImageView img_perfil;
    EditText ed_email, ed_telefone, ed_cpf, ed_nome_user;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_user);

        ed_email = findViewById(R.id.ed_email);
        ed_telefone = findViewById(R.id.ed_telefone);
        ed_cpf = findViewById(R.id.ed_cpf);
        ed_nome_user = findViewById(R.id.ed_nome_user);
        img_perfil = findViewById(R.id.img_perfil);
        bt_salvar_user = findViewById(R.id.bt_salvar_user);
        bt_foto = findViewById(R.id.bt_foto);
        bt_voltar_user = findViewById(R.id.bt_voltar_user);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_IMAGE_CAPTURE);
        }

        bt_salvar_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user;
                user =  new User();

                user.setNome(ed_nome_user.getText().toString());
                user.setCpf(Integer.parseInt(ed_cpf.getText().toString()));
                user.setTelefone(Integer.parseInt(ed_telefone.getText().toString()));
                user.setEmail(ed_email.getText().toString());
               // user.setImagem(img_perfil.setImageBitmap();

                UserDAO dao;
                dao = new UserDAO(Cadastro_user.this);
                dao.salvarUsuario(user);

                Toast.makeText(Cadastro_user.this, "Usuario cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                limparCampos();
            }
        });

        bt_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent(v);
            }
        });

        bt_voltar_user.setOnClickListener(new View.OnClickListener() {
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
        Intent telaPrincipal = new Intent(Cadastro_user.this, MainActivity.class);
        startActivity(telaPrincipal);
        finish();
    }
    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img_perfil.setImageBitmap(imageBitmap);
        }
    }
    private void limparCampos() {
        ed_nome_user.setText("");
        ed_cpf.setText("");
        ed_telefone.setText("");
        ed_email.setText("");
    }
}