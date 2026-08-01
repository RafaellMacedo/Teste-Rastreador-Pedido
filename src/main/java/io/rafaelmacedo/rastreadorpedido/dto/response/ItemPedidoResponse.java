package io.rafaelmacedo.rastreadorpedido.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        Long produtoId,
        Integer quantidade,
        BigDecimal valor
) {
}
