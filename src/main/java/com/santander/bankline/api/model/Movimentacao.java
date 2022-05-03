package com.santander.bankline.api.model;

import java.time.LocalDateTime;

public class Movimentacao {
    private Integer id;
    private LocalDateTime datHora;
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatHora() {
        return datHora;
    }

    public void setDatHora(LocalDateTime datHora) {
        this.datHora = datHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }
}
