package br.com.meli.apirestaurante.apirestaurante.dto;

import java.util.Map;

public class ExceptionFieldDTO {

    private Map<String, String> errors;

    public ExceptionFieldDTO(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
