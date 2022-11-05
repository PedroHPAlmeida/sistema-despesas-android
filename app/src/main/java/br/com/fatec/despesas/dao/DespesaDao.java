package br.com.fatec.despesas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.despesas.model.Despesa;

public class DespesaDao extends SQLiteOpenHelper {

    private final String TABELA = "tb_despesas";

    public DespesaDao(@Nullable Context context) {
        super(context, "db_despesas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABELA + "(" +
                "id INTEGER PRIMARY KEY," +
                "descricao VARCHAR(100) NOT NULL," +
                "valor DOUBLE NOT NULL," +
                "data DATE NOT NULL," +
                "mes_corrente VARCHAR(20) NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public long insert(Despesa despesa){
        ContentValues contentValues = new ContentValues();
        contentValues.put("descricao", despesa.getDescricao());
        contentValues.put("valor", despesa.getValor().toString());
        contentValues.put("data", despesa.getData().toString());
        contentValues.put("mes_corrente", despesa.getMesCorrente());

        return getWritableDatabase().insert(TABELA, null, contentValues);
    }

    public List<Despesa> selectAll(){
        String sql = "SELECT * FROM " + TABELA;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        List<Despesa> despesas = new ArrayList<>();

        while(cursor.moveToNext()){
            Despesa despesa = new Despesa();
            despesa.setId(cursor.getInt(0));
            despesa.setDescricao(cursor.getString(1));
            despesa.setValor(BigDecimal.valueOf(cursor.getDouble(2)));
            despesa.setData(cursor.getString(3));
            despesa.setMesCorrente(cursor.getString(4));
            despesas.add(despesa);
        }
        return despesas;
    }
}
