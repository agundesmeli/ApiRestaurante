package br.com.meli.apirestaurante.apirestaurante.converter;

import br.com.meli.apirestaurante.apirestaurante.dto.MesaDTO;
import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.service.MesaService;

public class MesaConverter {

    public static MesaDTO converteEntityToDTO(Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getPedidos(), MesaService.calcularValorTotalMesa(mesa));
        return mesaDTO;
    }
}
