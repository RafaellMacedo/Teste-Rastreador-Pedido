package io.rafaelmacedo.rastreadorpedido.dto.request;

import io.rafaelmacedo.rastreadorpedido.model.PedidoStatus;

public record AtualizarStatusRequestDTO(
        PedidoStatus status
) {
}
