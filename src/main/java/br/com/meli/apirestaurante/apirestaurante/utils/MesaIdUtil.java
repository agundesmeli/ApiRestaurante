package br.com.meli.apirestaurante.apirestaurante.utils;

import br.com.meli.apirestaurante.apirestaurante.entity.Mesa;
import br.com.meli.apirestaurante.apirestaurante.exception.MesaIdAlreadyExistsException;
import br.com.meli.apirestaurante.apirestaurante.exception.MesaIdDoesNotExistException;

import static br.com.meli.apirestaurante.apirestaurante.service.MesaService.mesaRepository;

public class MesaIdUtil {

    public static void mesaIdExistsValidation(Mesa mesa) {
        if (mesaRepository.getMesaById(mesa.getId()) != null) {
            throw new MesaIdAlreadyExistsException("Já existe uma mesa com este ID.");
        }
    }

    public static void mesaIdDoNotExistsValidation(Integer id) {
        if (mesaRepository.getMesaById(id) == null) {
            throw new MesaIdDoesNotExistException("Não existe mesa com este ID.");
        }
    }

}
