package br.com.meli.apirestaurante.apirestaurante.utils;

import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.exception.MesaIdDoesNotExistException;
import br.com.meli.apirestaurante.apirestaurante.exception.PedidoIdAlreadyExistsException;

import java.util.List;

import static br.com.meli.apirestaurante.apirestaurante.service.MesaService.mesaRepository;


public class PedidoIdUtil {

    public static void pedidoIdExistsValidation(List<Pedido> pedidos, Pedido pedido) {
        for (Pedido p : pedidos) {
            if (p.getId().equals(pedido.getId())) {
                throw new PedidoIdAlreadyExistsException("Já existe um pedido com este ID.");
            }
        }
    }
}
