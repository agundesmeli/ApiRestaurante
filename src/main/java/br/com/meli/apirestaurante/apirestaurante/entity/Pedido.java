package br.com.meli.apirestaurante.apirestaurante.entity;

import java.util.List;

public class Pedido {

    private Integer id;
    private Integer idMesa;
    private List<Prato> pratos;

    public Pedido(Integer id, Integer idMesa, List<Prato> pratos) {
        this.id = id;
        this.idMesa = idMesa;
        this.pratos = pratos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMesa() {
        return idMesa;
    }

    public void setMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
