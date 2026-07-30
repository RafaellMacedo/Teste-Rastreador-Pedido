package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.dto.request.ProdutoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.ProdutoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.mapper.ProdutoMapper;
import io.rafaelmacedo.rastreadorpedido.model.Produto;
import io.rafaelmacedo.rastreadorpedido.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto produto = mapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return mapper.toResponse(salvo);
    }

    public List<ProdutoResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
