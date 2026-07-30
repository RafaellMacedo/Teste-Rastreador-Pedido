package io.rafaelmacedo.rastreadorpedido.controller;

import io.rafaelmacedo.rastreadorpedido.dto.auth.*;
import io.rafaelmacedo.rastreadorpedido.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request){
        return service.login(request);
    }
}