package io.rafaelmacedo.rastreadorpedido.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<?> handleEmailJaCadastrado(
            EmailAlreadyRegisteredException ex
    ) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponse(
                    ex.getMessage(),
                    LocalDateTime.now()
            ));
    }

    public record ErrorResponse(
            String mensagem,
            LocalDateTime data
    ) {}
}