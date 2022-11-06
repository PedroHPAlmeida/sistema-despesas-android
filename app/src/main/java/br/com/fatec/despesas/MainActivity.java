package br.com.fatec.despesas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.fatec.despesas.adapter.DespesaAdapter;
import br.com.fatec.despesas.dao.DespesaDao;
import br.com.fatec.despesas.dto.DespesaDto;
import br.com.fatec.despesas.model.Despesa;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDespesas;
    private Button buttonNovaDespesa;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerViewDespesas = findViewById(R.id.recyclerViewDespesas);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();
        preencherListView();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void preencherListView(){
        DespesaDao despesaDao = new DespesaDao(MainActivity.this);
        List<Despesa> despesas = despesaDao.selectAll();
        DespesaAdapter adapter = new DespesaAdapter(DespesaDto.converter(despesas));
        this.recyclerViewDespesas.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        this.recyclerViewDespesas.setAdapter(adapter);
    }

}