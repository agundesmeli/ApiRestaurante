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
public class MesaServiceTest {

    private MesaRepository mesaRepository;
    private MesaService mesaService;
    private List<Mesa> mesasMock;
    private List<Pedido> pedidosMock;
    private List<Prato> pratosMock;
    private Mesa mesaMock;


    @BeforeEach
    public void init() {
        Prato prato = new Prato(100, 40.00, "Costela", 2);
        this.pratosMock = new ArrayList<>(Collections.singletonList(prato));
        this.pedidosMock = new ArrayList<>(Collections.singletonList(new Pedido(100, 100, pratosMock)));
        this.mesaMock = new Mesa(100, this.pedidosMock);
        this.mesasMock = new ArrayList<>(Collections.singletonList(new Mesa(100, pedidosMock)));

        this.mesaRepository = Mockito.mock(MesaRepository.class);
        this.mesaService = new MesaService(this.mesaRepository);
    }

    @Test
    public void shouldReturnListOfTables() {
        Assertions.assertNotNull(Mockito.when(this.mesaService.retornarMesas()).thenReturn(this.mesasMock));
    }

    @Test
    public void shouldCallAddTableMethodFromRepository() {
        //Arrange
        Mockito.doNothing().when(this.mesaRepository).addMesa(this.mesaMock);

        //Act
        this.mesaService.criarMesa(this.mesaMock);

        //Assert
        Mockito.verify(this.mesaRepository).addMesa(this.mesaMock);
    }

    @Test
    public void shouldCalculateRightTotalValueForTheTable() {
        //Arrange
        double expectedTableValue = 80.00;

        //Act
        double tableValue = MesaService.calcularValorTotalMesa(this.mesaMock);

        //Assert
        assertThat(tableValue).usingRecursiveComparison().isEqualTo(expectedTableValue);
    }
}
