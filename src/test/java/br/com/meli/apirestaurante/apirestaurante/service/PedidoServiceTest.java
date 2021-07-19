package br.com.meli.apirestaurante.apirestaurante.service;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import br.com.meli.apirestaurante.apirestaurante.entity.Prato;
import br.com.meli.apirestaurante.apirestaurante.repository.MesaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PedidoServiceTest {

    private MesaRepository mesaRepository;
    private MesaService mesaService;
    private PedidoService pedidoService;
    private List<Mesa> mesasMock;
    private List<Pedido> pedidosMock;
    private List<Prato> pratosMock;
    private Mesa mesaMock;
    private Pedido pedidoMock;


    @BeforeEach
    public void init() {
        Prato prato = new Prato(100, 40.00, "Costela", 2);
        this.pratosMock = new ArrayList<>(Collections.singletonList(prato));
        this.pedidoMock = new Pedido(100, 100, this.pratosMock);
        this.pedidosMock = new ArrayList<>(Collections.singletonList(this.pedidoMock));
        this.mesaMock = new Mesa(100, this.pedidosMock);
        this.mesasMock = new ArrayList<>(Collections.singletonList(this.mesaMock));

        this.mesaRepository = Mockito.mock(MesaRepository.class);
        this.mesaService = new MesaService(this.mesaRepository);
        this.pedidoService = new PedidoService(this.mesaRepository);
    }

    @Test
    public void shouldCalculateRightTotalValueForTheOrder() {
        //Arrange
        double expectedOrderValue = 80.00;

        //Act
        double orderValue = PedidoService.calcularValorTotalPedido(this.pedidoMock);

        //Assert
        assertThat(orderValue).usingRecursiveComparison().isEqualTo(expectedOrderValue);
    }


}
