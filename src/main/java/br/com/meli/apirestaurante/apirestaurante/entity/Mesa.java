package br.com.meli.apirestaurante.apirestaurante.entity;

import java.util.List;

public class Mesa {

    private Integer id;
    private List<Pedido> pedidos;

    public Mesa(Integer id, List<Pedido> pedidos) {
        this.id = id;
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
