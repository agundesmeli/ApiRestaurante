package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;

public class MesaService {

    public static Double calcularValorTotalMesa(Mesa mesa) {
        Double valorTotalMesa = 0.0;
        for (Pedido p : mesa.getPedidos()) {
            valorTotalMesa=+PedidoService.calcularValorTotalPedido(p);
        }
        return valorTotalMesa;
    }
}
