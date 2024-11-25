package com.example.treinos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO extends SQLiteOpenHelper {
    public static  final String NOME_BANCO = "bdCross";
    public static final int VERSAO_BANCO = 1;
    public static final String TABELA_MOVIMENTOS = "movimentos";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TIPO = "tipo";
    public static final String COLUNA_DESCRICAO = "descricao";
    public static final String COLUNA_VIDEO = "video";

    public MovimentoDAO (Context context){ super( context, NOME_BANCO, null, VERSAO_BANCO);}


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABELA_MOVIMENTOS + "(" +
                COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_NOME + " TEXT NOT NULL, " +
                COLUNA_TIPO + " TEXT NOT NULL, " +
                COLUNA_DESCRICAO + " TEXT NOT NULL) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarMovimento(Movimento m){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores;
        valores = new ContentValues();
        valores.put(COLUNA_NOME, m.getNome());
        valores.put(COLUNA_TIPO, m.getTipo());
        valores.put(COLUNA_DESCRICAO, m.getDescricao());


        db.insert(TABELA_MOVIMENTOS, null, valores);
        db.close();
    }

    public Movimento consultarPorId( int id){
        Movimento m;
        m = null;
        String parametro[] = {String.valueOf(id)};
        String campos [] = { "id, nome, tipo, descricao"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABELA_MOVIMENTOS, campos, "id = ?", parametro, null, null, null, null);
        if(cr.moveToFirst()){
            m = new  Movimento();
            m.setId(cr.getInt(0));
            m.setNome(cr.getString(1));
            m.setTipo(cr.getString(2));
            m.setDescricao(cr.getString(3));

        }
        db.close();
        return m;

    }
    public List<Movimento> exibirDados(){
        List<Movimento> movimento = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT id, nome FROM " + TABELA_MOVIMENTOS;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){

            do{

                Movimento m = new Movimento();
                m.setId(cursor.getInt(0));
                m.setNome(cursor.getString(1));
                movimento.add(m);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return movimento;
    }

    public void excluirItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String parametro[] = {String.valueOf(id)};
        db.delete(TABELA_MOVIMENTOS, " id = ? ", parametro);
        db.close();
    }
}
