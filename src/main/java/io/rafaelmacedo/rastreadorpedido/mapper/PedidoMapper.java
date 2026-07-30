package io.rafaelmacedo.rastreadorpedido.mapper;

import io.rafaelmacedo.rastreadorpedido.dto.request.EnderecoEntregaRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.request.ItemPedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.request.PedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequestDTO dto, Cliente cliente) {

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setStatus(PedidoStatus.RECEBIDO);
        pedido.setDataCriacao(LocalDateTime.now());

        pedido.setEnderecoEntrega(toEndereco(dto.endereco()));

        dto.itens()
            .stream()
            .map(this::toItem)
            .forEach(pedido::adicionarItem);

        return pedido;
    }

    public PedidoResponseDTO toResponse(Pedido pedido) {

        return PedidoResponseDTO.builder()
                .id(pedido.getId())
                .clienteId(pedido.getCliente().getId())
                .status(pedido.getStatus())
                .dataCriacao(pedido.getDataCriacao())
                .build();
    }

    private EnderecoEntrega toEndereco(EnderecoEntregaRequestDTO dto) {

        EnderecoEntrega endereco = new EnderecoEntrega();

        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setCep(dto.cep());

        return endereco;
    }

    private ItemPedido toItem(ItemPedidoRequestDTO dto) {

        ItemPedido item = new ItemPedido();

        item.setProdutoId(dto.produtoId());
        item.setQuantidade(dto.quantidade());

        return item;
    }

}