package io.rafaelmacedo.rastreadorpedido.mapper;

import io.rafaelmacedo.rastreadorpedido.dto.request.ProdutoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.ProdutoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {
        return Produto.builder()
                .nome(dto.nome())
                .preco(dto.preco())
                .build();
    }

    public ProdutoResponseDTO toResponse(Produto produto) {
        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .build();
    }

}
