package br.com.fatec.despesas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.fatec.despesas.dao.DespesaDao;
import br.com.fatec.despesas.model.Despesa;

public class MainActivity extends AppCompatActivity {

    private ListView listViewDespesas;
    private Button buttonNovaDespesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listViewDespesas = findViewById(R.id.listViewDespesas);
        this.buttonNovaDespesa = findViewById(R.id.buttonNovaDespesa);
        preencherListView();

        this.buttonNovaDespesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroDespesa.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        preencherListView();
    }

    public void preencherListView(){
        DespesaDao despesaDao = new DespesaDao(MainActivity.this);
        List<Despesa> despesas = despesaDao.selectAll();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, despesas);
        this.listViewDespesas.setAdapter(adapter);
    }

    public void vincularComponentes(){

    }
}