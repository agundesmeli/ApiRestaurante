package br.com.meli.apirestaurante.apirestaurante.dto;

import br.com.meli.apirestaurante.apirestaurante.entity.Prato;
import br.com.meli.apirestaurante.apirestaurante.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PedidoDTO {

    private Integer id;
    private Integer idMesa;
    private Status status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;
    private List<Prato> pratos;
    private Double valorTotal;

    public PedidoDTO(Integer id, Integer idMesa, Status status, LocalDate data, List<Prato> pratos, Double valorTotal) {
        this.id = id;
        this.idMesa = idMesa;
        this.status = status;
        this.data = data;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
