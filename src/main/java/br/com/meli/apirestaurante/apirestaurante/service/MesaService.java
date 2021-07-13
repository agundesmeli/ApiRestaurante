package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.repository.MesaRepository;
import br.com.meli.apirestaurante.apirestaurante.utils.MesaIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    public static MesaRepository mesaRepository;

    public MesaService() {
    }

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        MesaService.mesaRepository = mesaRepository;
    }

    public List<Mesa> retornarMesas() {
        return mesaRepository.getList();
    }

    public static Double calcularValorTotalMesa(Mesa mesa) {
        Double valorTotalMesa = 0.0;
        for (Pedido p : mesa.getPedidos()) {
            valorTotalMesa=+PedidoService.calcularValorTotalPedido(p);
        }
        return valorTotalMesa;
    }

    public static void criarMesa(Mesa mesa) {
        MesaIdUtil.mesaIdExistsValidation(mesa);
        mesaRepository.addMesa(mesa);
    }

}
