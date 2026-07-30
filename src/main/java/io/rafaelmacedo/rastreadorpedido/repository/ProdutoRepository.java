package io.rafaelmacedo.rastreadorpedido.repository;

import io.rafaelmacedo.rastreadorpedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
