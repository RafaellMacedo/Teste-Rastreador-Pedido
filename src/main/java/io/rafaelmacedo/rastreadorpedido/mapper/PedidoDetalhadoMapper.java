package io.rafaelmacedo.rastreadorpedido.mapper;

import io.rafaelmacedo.rastreadorpedido.dto.response.EnderecoEntregaResponse;
import io.rafaelmacedo.rastreadorpedido.dto.response.ItemPedidoResponse;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoDetalhadoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.model.EnderecoEntrega;
import io.rafaelmacedo.rastreadorpedido.model.ItemPedido;
import io.rafaelmacedo.rastreadorpedido.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoDetalhadoMapper {

    public PedidoDetalhadoResponseDTO toDetalhadoResponse(Pedido pedido) {
        return new PedidoDetalhadoResponseDTO(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getStatus(),
                pedido.getDataCriacao(),
                pedido.getTotal(),
                toEnderecoResponse(pedido.getEnderecoEntrega()),
                toItensResponse(pedido.getItens())
        );
    }

    private EnderecoEntregaResponse toEnderecoResponse(EnderecoEntrega endereco) {
        return new EnderecoEntregaResponse(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }

    private List<ItemPedidoResponse> toItensResponse(List<ItemPedido> itens) {
        return itens.stream()
                .map(this::toItemResponse)
                .toList();
    }

    private ItemPedidoResponse toItemResponse(ItemPedido item) {
        return new ItemPedidoResponse(
                item.getProdutoId(),
                item.getQuantidade(),
                item.getUnitario()
        );
    }
}
