package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.dto.request.ItemPedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.request.PedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.exception.ClienteNotFoundException;
import io.rafaelmacedo.rastreadorpedido.mapper.PedidoMapper;
import io.rafaelmacedo.rastreadorpedido.model.*;
import io.rafaelmacedo.rastreadorpedido.repository.ClienteRepository;
import io.rafaelmacedo.rastreadorpedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoResponseDTO criar(PedidoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(dto, cliente);
        Pedido pedidoNovo = pedidoRepository.save(pedido);
        return pedidoMapper.toResponse(pedidoNovo);
    }
}
