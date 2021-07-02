package br.com.meli.apirestaurante.apirestaurante.dto;

import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;

import java.util.List;

public class MesaDTO {

    private Integer id;
    private List<Pedido> pedidos;
    private Double valorTotalConsumido;

    public MesaDTO(Integer id, List<Pedido> pedidos, Double valorTotalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorTotalConsumido = valorTotalConsumido;
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

    public Double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(Double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }
}
