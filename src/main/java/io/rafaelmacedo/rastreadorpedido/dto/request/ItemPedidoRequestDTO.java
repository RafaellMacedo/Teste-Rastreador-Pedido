package io.rafaelmacedo.rastreadorpedido.dto.request;

public record ItemPedidoRequestDTO(
        Long produtoId,
        Integer quantidade
) {
}
