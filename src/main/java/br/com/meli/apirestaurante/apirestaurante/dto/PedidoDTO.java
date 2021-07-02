package br.com.meli.apirestaurante.apirestaurante.dto;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Prato;

import java.util.List;

public class PedidoDTO {

    private Integer id;
    private Integer idMesa;
    private List<Prato> pratos;
    private Double valorTotal;

    public PedidoDTO(Integer id, Integer idMesa, List<Prato> pratos, Double valorTotal) {
        this.id = id;
        this.idMesa = idMesa;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
