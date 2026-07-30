package io.rafaelmacedo.rastreadorpedido.controller;

import io.rafaelmacedo.rastreadorpedido.dto.request.ProdutoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.ProdutoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO criar(@RequestBody ProdutoRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }
}
