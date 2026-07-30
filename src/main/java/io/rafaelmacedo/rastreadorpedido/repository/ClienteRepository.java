package io.rafaelmacedo.rastreadorpedido.repository;

import io.rafaelmacedo.rastreadorpedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);
}
