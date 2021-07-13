package br.com.meli.apirestaurante.apirestaurante.repository;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.entity.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MesaRepository {

    private static final File FILE = new File("mesas.json");
    @Autowired
    private ObjectMapper mapper;

    public List<Mesa> getList() {
        List<Mesa> mesas = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Mesa>> typeReference = new TypeReference<List<Mesa>>() {};
            mesas = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mesas;
    }

    public Mesa getMesaById(Integer id) {
        List<Mesa> mesas = this.getList();
        Optional<Mesa> mesaOptional = mesas
                .stream()
                .filter(mesa -> mesa.getId().equals(id))
                .findAny();
        return mesaOptional.orElse(null);
    }

    public void addMesa(Mesa mesa) {
        try {
            List<Mesa> mesas = getList();
            mesas.add(mesa);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, mesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Mesa deleteMesa(Integer id) {
        try {
            List<Mesa> mesas = this.getList();
            Optional<Mesa> mesaOptional = mesas
                    .stream()
                    .filter(mesa -> mesa.getId().equals(id))
                    .findAny();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> !m.getId().equals(id)).collect(Collectors.toList());
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedMesas);
            out.close();
            return mesaOptional.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPedido(Integer idMesa, Pedido pedido) {
        try {
            Mesa mesa = this.getMesaById(idMesa);
            List<Pedido> pedidos = mesa.getPedidos();
            pedidos.add(pedido);

            mesa.setPedidos(pedidos);
            List<Mesa> mesas = getList();

            Optional<Mesa> mesaOptional = mesas
                    .stream()
                    .filter(m -> m.getId().equals(idMesa))
                    .findAny();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> !m.getId().equals(idMesa)).collect(Collectors.toList());

            if(mesaOptional.isPresent()) {
                mesaOptional.get().setPedidos(mesa.getPedidos());
                updatedMesas.add(mesaOptional.get());
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, mesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePedido(Integer idMesa, Integer idPedido) {
        try {
            Mesa mesa = this.getMesaById(idMesa);
            List<Pedido> pedidos = mesa.getPedidos();
            pedidos.removeIf(p -> p.getId().equals(idPedido));

            mesa.setPedidos(pedidos);

            List<Mesa> mesas = getList();
            Optional<Mesa> mesaOptional = mesas
                    .stream()
                    .filter(m -> m.getId().equals(idMesa))
                    .findAny();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> !m.getId().equals(idMesa)).collect(Collectors.toList());

            if(mesaOptional.isPresent()) {
                mesaOptional.get().setPedidos(mesa.getPedidos());
                updatedMesas.add(mesaOptional.get());
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedMesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updatePedido(Integer idMesa, Pedido pedido) {
        try {
            deletePedido(idMesa, pedido.getId());
            addPedido(idMesa, pedido);
            Mesa mesa = this.getMesaById(idMesa);

            List<Mesa> mesas = getList();
            Optional<Mesa> mesaOptional = mesas
                    .stream()
                    .filter(m -> m.getId().equals(idMesa))
                    .findAny();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> !m.getId().equals(idMesa)).collect(Collectors.toList());

            if(mesaOptional.isPresent()) {
                mesaOptional.get().setPedidos(mesa.getPedidos());
                updatedMesas.add(mesaOptional.get());
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedMesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
