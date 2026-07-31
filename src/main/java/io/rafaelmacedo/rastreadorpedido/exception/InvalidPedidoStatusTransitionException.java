package io.rafaelmacedo.rastreadorpedido.exception;

public class InvalidPedidoStatusTransitionException extends RuntimeException {

    public InvalidPedidoStatusTransitionException(String message) {
        super(message);
    }
}
