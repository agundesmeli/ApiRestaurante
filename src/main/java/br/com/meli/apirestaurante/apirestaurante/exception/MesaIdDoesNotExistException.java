package br.com.meli.apirestaurante.apirestaurante.exception;

public class MesaIdDoesNotExistException extends RuntimeException {

    public MesaIdDoesNotExistException() {
    }

    public MesaIdDoesNotExistException(String message) {
        super(message);
    }
}
