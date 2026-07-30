package io.rafaelmacedo.rastreadorpedido.security;

import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class ClienteUserDetails {

    public static UserDetails build(Cliente cliente) {
        return User.builder()
                .username(cliente.getEmail())
                .password(cliente.getSenha())
                .roles("USER")
                .build();
    }
}