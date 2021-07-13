package br.com.meli.apirestaurante.apirestaurante.exception;

public class PedidoIdAlreadyExistsException extends RuntimeException {

    public PedidoIdAlreadyExistsException() {
    }

    public PedidoIdAlreadyExistsException(String message) {
        super(message);
    }
}
