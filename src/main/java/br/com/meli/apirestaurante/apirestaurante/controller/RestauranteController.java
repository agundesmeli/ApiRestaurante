package br.com.meli.apirestaurante.apirestaurante.controller;

import br.com.meli.apirestaurante.apirestaurante.dto.MesaDTO;
import br.com.meli.apirestaurante.apirestaurante.entity.Caixa;
import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    Caixa caixa = new Caixa();

    @GetMapping
    @RequestMapping("/mesa")
    public ResponseEntity<?> obterPedidos(@RequestBody Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getPedidos(), MesaService.calcularValorTotalMesa(mesa));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mesaDTO);
    }

    @GetMapping
    @RequestMapping("/fechamento")
    public ResponseEntity<?> fecharPedidos(@RequestBody Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa.getId(), mesa.getPedidos(), MesaService.calcularValorTotalMesa(mesa));
        caixa.dinheiroEmCaixa = caixa.getDinheiroEmCaixa() + mesaDTO.getValorTotalConsumido();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mesaDTO);
    }

    @GetMapping
    @RequestMapping("/caixa")
    public Double consultarCaixa() {
        return caixa.getDinheiroEmCaixa();
    }
}
