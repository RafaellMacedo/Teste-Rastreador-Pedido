package io.rafaelmacedo.rastreadorpedido.controller;

import io.rafaelmacedo.rastreadorpedido.dto.request.AtualizarStatusRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.request.PedidoRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoDetalhadoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.PedidoResponseDTO;
import io.rafaelmacedo.rastreadorpedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponseDTO criar(
            @RequestBody PedidoRequestDTO dto,
            Authentication authentication
    ) {
        String email = authentication.getName();
        return service.criar(dto, email);
    }

    @GetMapping
    public List<PedidoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoDetalhadoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PatchMapping("/{id}/status")
    public PedidoResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestBody AtualizarStatusRequestDTO dto) {
        return service.atualizarStatus(id, dto);
    }
}
