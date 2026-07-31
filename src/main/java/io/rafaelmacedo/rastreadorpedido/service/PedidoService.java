package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.dto.request.AtualizarStatusRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.request.PedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.exception.ClienteNotFoundException;
import io.rafaelmacedo.rastreadorpedido.exception.PedidoNotFoundException;
import io.rafaelmacedo.rastreadorpedido.mapper.PedidoMapper;
import io.rafaelmacedo.rastreadorpedido.model.*;
import io.rafaelmacedo.rastreadorpedido.repository.ClienteRepository;
import io.rafaelmacedo.rastreadorpedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoResponseDTO criar(PedidoRequestDTO dto, String email) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(dto, cliente);
        Pedido pedidoNovo = pedidoRepository.save(pedido);
        return pedidoMapper.toResponse(pedidoNovo);
    }

    public List<PedidoResponseDTO> listarTodos() {
        return pedidoMapper.toResponseList(pedidoRepository.findAll());
    }

    public PedidoResponseDTO buscarPorId(Long pedidoId) {
        Pedido pedido = findPedidoByIdOrFail(pedidoId);
        return pedidoMapper.toResponse(pedido);
    }

    public PedidoResponseDTO atualizarStatus(Long pedidoId,
                                             AtualizarStatusRequestDTO dto) {
        Pedido pedido = findPedidoByIdOrFail(pedidoId);

        pedido.getStatus().validarTransicao(dto.status());

        pedido.setStatus(dto.status());
        Pedido pedidoAtualizado = pedidoRepository.save(pedido);

        return pedidoMapper.toResponse(pedidoAtualizado);
    }

    private Pedido findPedidoByIdOrFail(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() ->
                        new PedidoNotFoundException("Pedido não encontrado"));
    }
}
