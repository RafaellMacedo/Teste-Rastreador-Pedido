package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.dto.auth.*;
import io.rafaelmacedo.rastreadorpedido.exception.ClienteNotFoundException;
import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import io.rafaelmacedo.rastreadorpedido.repository.ClienteRepository;
import io.rafaelmacedo.rastreadorpedido.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final ClienteRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(
            ClienteRepository repository,
            PasswordEncoder encoder,
            JwtService jwtService
    ){
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO request){
        Cliente cliente = repository.findByEmail(request.email())
            .orElseThrow(() ->
                new ClienteNotFoundException("Email ou senha invalidos")
            );

        String token = jwtService.generateToken(cliente.getEmail());
        return new LoginResponseDTO(token);
    }
}