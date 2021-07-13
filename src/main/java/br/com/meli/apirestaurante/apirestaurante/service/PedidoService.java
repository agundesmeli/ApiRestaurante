package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.converter.PedidoConverter;
import br.com.meli.apirestaurante.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.entity.Prato;
import br.com.meli.apirestaurante.apirestaurante.entity.Status;
import br.com.meli.apirestaurante.apirestaurante.repository.MesaRepository;
import br.com.meli.apirestaurante.apirestaurante.utils.MesaIdUtil;
import br.com.meli.apirestaurante.apirestaurante.utils.PedidoIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class PedidoService {

    private static MesaRepository mesaRepository;

    public PedidoService() {
    }

    @Autowired
    public PedidoService(MesaRepository mesaRepository) {
        PedidoService.mesaRepository = mesaRepository;
    }

    public static Double calcularValorTotalPedido(Pedido pedido) {
        double valorTotalPedido = 0.0;
        for (Prato p : pedido.getPratos()) {
            valorTotalPedido=+PratoService.calcularValorTotalPrato(p);
        }
        return valorTotalPedido;
    }

    public static void criarPedido(Integer mesaId, Pedido pedido) {
        MesaIdUtil.mesaIdDoNotExistsValidation(mesaId);

        List<Pedido> pedidos = mesaRepository.getMesaById(mesaId).getPedidos();

        PedidoIdUtil.pedidoIdExistsValidation(pedidos, pedido);

        mesaRepository.addPedido(mesaId, pedido);
    }

    public static List<Pedido> consultarPedidosMesa(Integer id) {
        MesaIdUtil.mesaIdDoNotExistsValidation(id);
        Mesa mesa = mesaRepository.getMesaById(id);
        return mesa.getPedidos();

    }

    public static void alterarPedido(Integer id, Pedido pedido) {
        MesaIdUtil.mesaIdDoNotExistsValidation(id);
        mesaRepository.updatePedido(id, pedido);

    }

    public static void deletarPedidoMesa(Integer id, Integer idPedido) {
        MesaIdUtil.mesaIdDoNotExistsValidation(id);
        mesaRepository.deletePedido(id, idPedido);
    }

    public static void fecharPedidos(Mesa mesa) {
        for (Pedido p : mesa.getPedidos()) {
            p.setStatus(Status.FECHADO);
        }
    }

    public static Double calcularFaturamentoHoje() {
        List<Mesa> mesas = mesaRepository.getList();
        List<Pedido> pedidos = new ArrayList<>();
        List<PedidoDTO> pedidosHoje = new ArrayList<>();
        for (Mesa m : mesas) {
            pedidos = consultarPedidosMesa(m.getId());
            for (Pedido p : pedidos) {
                if (p.getData().equals(LocalDate.now())) {
                    PedidoConverter.converteEntityToDTO(p);
                    pedidosHoje.add(PedidoConverter.converteEntityToDTO(p));
                }
            }
        }
        Double faturamentoHoje = 0.0;
        for (PedidoDTO p : pedidosHoje) {
            faturamentoHoje+=p.getValorTotal();
        }
        return faturamentoHoje;
    }
}
