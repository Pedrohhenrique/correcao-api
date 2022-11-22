package com.example.demo.entity;

import javax.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    private String endereco;
    private String formaPagamento;
    private Integer parcelas;

    private Integer numero;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Items> items;

    public Pedido(String cep, String endereco, String formaPagamento, Integer parcelas, Integer numero, List<Items> items) {
        this.cep = cep;
        this.endereco = endereco;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.numero = numero;
        this.items = items;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
