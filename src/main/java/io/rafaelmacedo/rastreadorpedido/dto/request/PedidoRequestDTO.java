package io.rafaelmacedo.rastreadorpedido.dto.request;

import java.util.List;

public record PedidoRequestDTO(
    Long clienteId,
    EnderecoEntregaRequestDTO endereco,
    List<ItemPedidoRequestDTO> itens
) {
}
