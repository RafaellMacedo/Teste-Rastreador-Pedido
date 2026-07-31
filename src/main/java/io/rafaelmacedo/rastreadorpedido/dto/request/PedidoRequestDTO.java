package io.rafaelmacedo.rastreadorpedido.dto.request;

import java.util.List;

public record PedidoRequestDTO(
    EnderecoEntregaRequestDTO enderecoEntrega,
    List<ItemPedidoRequestDTO> itens
) {
}
