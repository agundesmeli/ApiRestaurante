package br.com.meli.apirestaurante.apirestaurante.exception;

public class MesaIdAlreadyExistsException extends RuntimeException {

    public MesaIdAlreadyExistsException() {
    }

    public MesaIdAlreadyExistsException(String message) {
        super(message);
    }
}
