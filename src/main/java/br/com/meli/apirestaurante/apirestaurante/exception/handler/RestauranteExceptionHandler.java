package br.com.meli.apirestaurante.apirestaurante.exception.handler;

import br.com.meli.apirestaurante.apirestaurante.dto.ExceptionDTO;
import br.com.meli.apirestaurante.apirestaurante.dto.ExceptionFieldDTO;
import br.com.meli.apirestaurante.apirestaurante.exception.DatabaseException;
import br.com.meli.apirestaurante.apirestaurante.exception.MesaIdAlreadyExistsException;
import br.com.meli.apirestaurante.apirestaurante.exception.MesaIdDoesNotExistException;
import br.com.meli.apirestaurante.apirestaurante.exception.PedidoIdAlreadyExistsException;
import br.com.meli.apirestaurante.apirestaurante.utils.FieldErros;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestauranteExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        ExceptionFieldDTO exceptions = FieldErros.processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<?> DatabaseHandler(DatabaseException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(MesaIdAlreadyExistsException.class)
    public ResponseEntity<?> mesaIdAlreadyExistsHandler(MesaIdAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(PedidoIdAlreadyExistsException.class)
    public ResponseEntity<?> pedidoIdAlreadyExistsHandler(PedidoIdAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(MesaIdDoesNotExistException.class)
    public ResponseEntity<?> mesaIdDoesNotExistHandler(MesaIdDoesNotExistException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }
}
