package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.dto.request.ClienteRequestDTO;
import io.rafaelmacedo.rastreadorpedido.dto.response.ClienteResponseDTO;
import io.rafaelmacedo.rastreadorpedido.exception.EmailAlreadyRegisteredException;
import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import io.rafaelmacedo.rastreadorpedido.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;

    public ClienteResponseDTO salvar(ClienteRequestDTO request) {

        if (repository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyRegisteredException(request.email());
        }

        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setSenha(
                passwordEncoder.encode(request.senha())
        );

        return ClienteResponseDTO.fromEntity(repository.save(cliente));
    }

    public Optional<Cliente> findByCode(Long clienteId) {
        return repository.findById(clienteId);
    }
}
