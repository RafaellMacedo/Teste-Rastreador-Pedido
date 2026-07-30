package io.rafaelmacedo.rastreadorpedido.service;

import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import io.rafaelmacedo.rastreadorpedido.repository.ClienteRepository;
import io.rafaelmacedo.rastreadorpedido.security.ClienteUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteDetailsService implements UserDetailsService {

    private final ClienteRepository repository;

    public ClienteDetailsService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Cliente cliente = repository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                    "Cliente não encontrado"
                ));
        return ClienteUserDetails.build(cliente);
    }
}