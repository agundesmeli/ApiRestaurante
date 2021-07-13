package br.com.meli.apirestaurante.apirestaurante.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    @NotNull(message = "O id do pedido não pode ser nulo")
    @Positive(message = "O id do pedido deve ser maior que 0")
    private Integer id;

    @NotNull(message = "O id da mesa não pode ser nulo")
    @Positive(message = "O id da mesa deve ser maior que 0")
    private Integer idMesa;

    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    private List<Prato> pratos;

    public Pedido(Integer id, Integer idMesa,List<Prato> pratos) {
        this.id = id;
        this.idMesa = idMesa;
        this.status = Status.ATIVO;
        this.data = LocalDate.now();
        this.pratos = pratos;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
