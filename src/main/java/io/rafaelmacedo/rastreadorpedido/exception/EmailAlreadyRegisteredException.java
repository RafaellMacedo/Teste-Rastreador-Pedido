package io.rafaelmacedo.rastreadorpedido.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException(String email) {
        super("O email '" + email + "' já esta cadastrado");
    }
}
