package br.com.meli.apirestaurante.apirestaurante.dto;

public class ExceptionDTO {

    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
