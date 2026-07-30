package io.rafaelmacedo.rastreadorpedido.dto.response;

import io.rafaelmacedo.rastreadorpedido.model.PedidoStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private PedidoStatus status;
    private LocalDateTime dataCriacao;

}
