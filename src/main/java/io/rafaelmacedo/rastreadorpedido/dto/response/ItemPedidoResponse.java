package io.rafaelmacedo.rastreadorpedido.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        Long produtoId,
        String nome,
        Integer quantidade,
        BigDecimal valor
) {
}
