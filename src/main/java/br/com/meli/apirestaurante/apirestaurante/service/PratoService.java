package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.entity.Prato;

public class PratoService {

    public static Double calcularValorTotalPrato(Prato prato) {
        Double valorTotalPrato = prato.getPreco()*prato.getQuantidade();
        return valorTotalPrato;
    }
}
