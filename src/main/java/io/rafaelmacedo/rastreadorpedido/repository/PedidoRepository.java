package io.rafaelmacedo.rastreadorpedido.repository;

import io.rafaelmacedo.rastreadorpedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
