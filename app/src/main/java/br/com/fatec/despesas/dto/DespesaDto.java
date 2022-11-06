package br.com.fatec.despesas.dto;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fatec.despesas.model.Despesa;

public class DespesaDto {

    private String despesa;
    private String valor;

    public DespesaDto(String despesa, String valor) {
        this.despesa = despesa;
        this.valor = valor;
    }

    public DespesaDto(Despesa despesa) {
        this.despesa = despesa.getDescricao();
        this.valor = despesa.getValor().toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<DespesaDto> converter(List<Despesa> despesas){
        return despesas.stream().map(DespesaDto::new).collect(Collectors.toList());
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
