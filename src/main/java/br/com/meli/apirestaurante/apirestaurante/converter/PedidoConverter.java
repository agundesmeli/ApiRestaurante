package br.com.meli.apirestaurante.apirestaurante.converter;

import br.com.meli.apirestaurante.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.service.PedidoService;

import java.util.ArrayList;
import java.util.List;


public class PedidoConverter {

    public static PedidoDTO converteEntityToDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO(pedido.getId(), pedido.getIdMesa(), pedido.getStatus(), pedido.getData(), pedido.getPratos(), PedidoService.calcularValorTotalPedido(pedido));
        return pedidoDTO;
    }

    public static List<PedidoDTO> converteListEntityToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();
        for (Pedido p : pedidos) {
            pedidoDTOS.add(converteEntityToDTO(p));
        }
        return pedidoDTOS;
    }
}
