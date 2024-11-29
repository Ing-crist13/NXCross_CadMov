package com.example.treinos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDAO extends SQLiteOpenHelper {

    public static  final String NOME_BANCO = "bdUser";
    public static final int VERSAO_BANCO = 1;
    public static final String TABELA_USUARIOS = "usuarios";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME_USUARIO = "nome";
    public static final String COLUNA_CPF = "cpf";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_IMAGEM = "imagem";

    public UserDAO (Context context){ super( context, NOME_BANCO, null, VERSAO_BANCO);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABELA_USUARIOS + "(" +
                COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_NOME_USUARIO + " TEXT NOT NULL, " +
                COLUNA_CPF + " INTEGER NOT NULL, " +
                COLUNA_TELEFONE + " INTEGER NOT NULL, " +
                COLUNA_EMAIL + " TEXT NOT NULL, " +
                COLUNA_IMAGEM + " CHAR NOT NULL); " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarUsuario(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores;
        valores = new ContentValues();
        valores.put(COLUNA_NOME_USUARIO, user.getNome());
        valores.put(COLUNA_CPF, user.getCpf());
        valores.put(COLUNA_TELEFONE, user.getTelefone());
        valores.put(COLUNA_EMAIL, user.getEmail());
    //   valores.put(COLUNA_IMAGEM, user.getImagem());

        db.insert(TABELA_USUARIOS, null, valores);
        db.close();
    }
}
