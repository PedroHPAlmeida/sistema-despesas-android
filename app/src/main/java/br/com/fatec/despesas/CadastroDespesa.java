package br.com.fatec.despesas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.fatec.despesas.dao.DespesaDao;
import br.com.fatec.despesas.model.Despesa;

public class CadastroDespesa extends AppCompatActivity {

    private EditText editTextDescricao;
    private EditText editTextValor;
    private EditText editTextData;
    private Spinner spinnerMesCorrente;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_despesa);

        vincularComponentes();
        preencherMesCorrente();

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DespesaDao despesaDao = new DespesaDao(CadastroDespesa.this);
                Despesa despesa = new Despesa(
                        editTextDescricao.getText().toString(),
                        new BigDecimal(editTextValor.getText().toString()),
                        editTextData.getText().toString(),
                        spinnerMesCorrente.getSelectedItem().toString()
                );
                long id = despesaDao.insert(despesa);
                if(id > 0){
                    Toast.makeText(CadastroDespesa.this, "Despesa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                    CadastroDespesa.this.finish();
                } else {
                    Toast.makeText(CadastroDespesa.this, "Algo deu errado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void preencherMesCorrente(){
        String[] meses = {"JANEIRO", "FEVEREIRO", "MARCO", "ABRIL", "MAIO", "JUNHO",
                          "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};
        ArrayAdapter adapter = new ArrayAdapter(CadastroDespesa.this,
                android.R.layout.simple_spinner_dropdown_item,
                meses);
        this.spinnerMesCorrente.setAdapter(adapter);
    }

    public void vincularComponentes(){
        this.editTextDescricao = findViewById(R.id.editTextDescricao);
        this.editTextValor = findViewById(R.id.editTextValor);
        this.editTextData = findViewById(R.id.editTextData);
        this.spinnerMesCorrente = findViewById(R.id.spinnerMesCorrente);
        this.buttonCadastrar = findViewById(R.id.buttonCadastrar);
    }
}