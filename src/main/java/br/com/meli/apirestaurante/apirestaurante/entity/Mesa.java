package br.com.meli.apirestaurante.apirestaurante.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.util.List;

public class Mesa {

    @NotNull(message = "O id da mesa não pode ser nulo")
    @Positive(message = "O id da mesa deve ser maior que 0")
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
