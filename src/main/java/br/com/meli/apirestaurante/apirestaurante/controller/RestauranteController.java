package br.com.meli.apirestaurante.apirestaurante.controller;

import br.com.meli.apirestaurante.apirestaurante.converter.MesaConverter;
import br.com.meli.apirestaurante.apirestaurante.converter.PedidoConverter;
import br.com.meli.apirestaurante.apirestaurante.dto.MesaDTO;
import br.com.meli.apirestaurante.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.apirestaurante.entity.Caixa;
import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.repository.MesaRepository;
import br.com.meli.apirestaurante.apirestaurante.service.MesaService;
import br.com.meli.apirestaurante.apirestaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    MesaRepository mesaRepository = new MesaRepository();

    private MesaService mesaService;
    private PedidoService pedidoService;

    public RestauranteController() {
    }

    @Autowired
    public RestauranteController(MesaService mesaService, PedidoService pedidoService) {
        this.mesaService = mesaService;
        this.pedidoService = pedidoService;
    }

    Caixa caixa = new Caixa();

    @PostMapping
    @RequestMapping("/mesa")
    public ResponseEntity<?> criarMesa(@Valid @RequestBody Mesa mesa) {
        mesaService.criarMesa(mesa);
        MesaDTO mesaDTO = MesaConverter.converteEntityToDTO(mesa);
        return ResponseEntity.status(HttpStatus.OK).body(mesaDTO);
    }

    @GetMapping
    @RequestMapping("/mesas")
    public ResponseEntity<?> obterMesas() {
        List<Mesa> mesas = mesaService.retornarMesas();
        return ResponseEntity.status(HttpStatus.OK).body(mesas);
    }

    @GetMapping
    @RequestMapping("/pedidos/{mesaId}")
    public ResponseEntity<?> obterPedidos(@PathVariable("mesaId") Integer mesaId) {
        List<Pedido> pedidos = pedidoService.consultarPedidosMesa(mesaId);
        List<PedidoDTO> pedidosDTOS = PedidoConverter.converteListEntityToDTO(pedidos);
        return ResponseEntity.status(HttpStatus.OK).body(pedidosDTOS);
    }

    @PostMapping
    @RequestMapping("/adicionar_pedido/{mesaId}")
    public ResponseEntity<?> criarPedido(@PathVariable("mesaId") Integer mesaId, @Valid @RequestBody Pedido pedido) {
        pedidoService.criarPedido(mesaId, pedido);
        PedidoDTO pedidoDTO = PedidoConverter.converteEntityToDTO(pedido);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoDTO);
    }

    @PutMapping
    @RequestMapping("/alterar_pedido/{mesaId}")
    public ResponseEntity<?> alterarPedido(@PathVariable("mesaId") Integer mesaId, @Valid @RequestBody Pedido pedido) {
        pedidoService.alterarPedido(mesaId, pedido);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    @RequestMapping("/excluir_pedido/{mesaId}/{pedidoId}")
    public ResponseEntity<?> excluirPedido(@PathVariable("mesaId") Integer mesaId, @PathVariable("pedidoId") Integer pedidoId) {
        pedidoService.deletarPedidoMesa(mesaId, pedidoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @RequestMapping("/fechamento")
    public ResponseEntity<?> fecharPedidos(@Valid @RequestBody Mesa mesa) {
        pedidoService.fecharPedidos(mesa);
        MesaDTO mesaDTO = MesaConverter.converteEntityToDTO(mesa);
        caixa.dinheiroEmCaixa = caixa.getDinheiroEmCaixa() + mesaDTO.getValorTotalConsumido();
        return ResponseEntity.status(HttpStatus.OK).body(mesaDTO);
    }

    @GetMapping
    @RequestMapping("/caixa")
    public Double consultarCaixa() {
        return caixa.getDinheiroEmCaixa();
    }

    @GetMapping
    @RequestMapping("/caixa_hoje")
    public Double consultarCaixaHoje() {
        return pedidoService.calcularFaturamentoHoje();
    }
}
