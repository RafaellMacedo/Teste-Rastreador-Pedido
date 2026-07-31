package io.rafaelmacedo.rastreadorpedido.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.rafaelmacedo.rastreadorpedido.exception.InvalidPedidoStatusTransitionException;

import java.util.Arrays;

public enum PedidoStatus {
    RECEBIDO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO;

    @JsonCreator
    public static PedidoStatus from(String value) {

        if (value == null || value.isBlank()) {
            return null;
        }

        String status = value.trim().toUpperCase();

        return Arrays.stream(values())
                .filter(s -> s.name().equals(status))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Status inválido: " + value));
    }

    public void validarTransicao(PedidoStatus novoStatus) {
        if (!permiteTransicaoPara(novoStatus)) {
            throw new InvalidPedidoStatusTransitionException(
                    "Não é permitido alterar o status de "
                            + this + " para " + novoStatus);
        }
    }

    public boolean permiteTransicaoPara(PedidoStatus novoStatus) {
        return switch (this) {
            case RECEBIDO ->
                novoStatus == EM_PREPARO || novoStatus == CANCELADO;

            case EM_PREPARO ->
                novoStatus == SAIU_PARA_ENTREGA || novoStatus == CANCELADO;

            case SAIU_PARA_ENTREGA ->
                novoStatus == ENTREGUE;

            case ENTREGUE, CANCELADO ->
                false;
        };
    }
}
