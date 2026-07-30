package io.rafaelmacedo.rastreadorpedido.dto.response;

import io.rafaelmacedo.rastreadorpedido.model.Cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String email
) {

    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }
}
