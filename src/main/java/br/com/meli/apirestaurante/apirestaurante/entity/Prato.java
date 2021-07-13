package br.com.meli.apirestaurante.apirestaurante.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Prato {

    @NotNull(message = "O id do prato não pode ser nulo")
    @Positive(message = "O id do prato deve ser maior que 0")
    private Integer id;

    @Positive(message = "O preço do prato deve ser maior que 0")
    @NotNull(message = "O preço do prato não pode ser nulo")
    private Double preco;

    private String descricao;

    @Positive(message = "A quantidade de pratos deve ser maior que 0")
    @NotNull(message = "A quantidade de pratos não pode ser nulo")
    private Integer quantidade;

    public Prato(Integer id, Double preco, String descricao, Integer quantidade) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
