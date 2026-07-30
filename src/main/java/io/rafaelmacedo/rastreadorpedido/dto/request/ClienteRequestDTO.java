package io.rafaelmacedo.rastreadorpedido.dto.request;

public record ClienteRequestDTO(
        String nome,
        String email,
        String senha
) {
}
