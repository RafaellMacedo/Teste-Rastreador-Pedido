package io.rafaelmacedo.rastreadorpedido.dto.request;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String nome,
        BigDecimal preco
) {
}
