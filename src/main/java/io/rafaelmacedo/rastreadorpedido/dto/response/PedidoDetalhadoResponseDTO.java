package io.rafaelmacedo.rastreadorpedido.dto.response;

import io.rafaelmacedo.rastreadorpedido.model.PedidoStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoDetalhadoResponseDTO(
        Long id,
        Long clienteId,
        PedidoStatus status,
        LocalDateTime dataCriacao,
        BigDecimal total,
        EnderecoEntregaResponse enderecoEntrega,
        List<ItemPedidoResponse> itens
) {
}