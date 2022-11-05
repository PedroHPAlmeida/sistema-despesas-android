package br.com.fatec.despesas.model;

import java.math.BigDecimal;

public class Despesa {

    private int id;
    private String descricao;
    private BigDecimal valor;
    private String data;
    private String mesCorrente;

    public Despesa(String descricao, BigDecimal valor, String data, String mesCorrente) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.mesCorrente = mesCorrente;
    }

    public Despesa(int id, String descricao, BigDecimal valor, String data, String mesCorrente){
        this(descricao, valor, data, mesCorrente);
        this.id = id;
    }

    public Despesa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMesCorrente() {
        return mesCorrente;
    }

    public void setMesCorrente(String mesCorrente) {
        this.mesCorrente = mesCorrente;
    }

    @Override
    public String toString() {
        return "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data='" + data + '\'' +
                ", mesCorrente='" + mesCorrente + '\'' +
                '}';
    }
}
