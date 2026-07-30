package io.rafaelmacedo.rastreadorpedido.controller;

import io.rafaelmacedo.rastreadorpedido.dto.request.ClienteRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.ClienteResponseDTO;
import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import io.rafaelmacedo.rastreadorpedido.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> store(
            @RequestBody ClienteRequestDTO request
    ) {
        log.info("Cadastrando novo cliente");

        return ResponseEntity.ok(
                service.salvar(request)
        );
    }

    @GetMapping("{clienteId}")
    public ResponseEntity<Cliente> obterDados(@PathVariable("codigo") Long clienteId) {
        return service.findByCode(clienteId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
