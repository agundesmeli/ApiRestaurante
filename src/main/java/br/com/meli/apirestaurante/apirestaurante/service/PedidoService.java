package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.entity.Prato;

public class PedidoService {

    public static Double calcularValorTotalPedido(Pedido pedido) {
        Double valorTotalPedido = 0.0;
        for (Prato p : pedido.getPratos()) {
            valorTotalPedido=+PratoService.calcularValorTotalPrato(p);
        }
        return valorTotalPedido;
    }
}
