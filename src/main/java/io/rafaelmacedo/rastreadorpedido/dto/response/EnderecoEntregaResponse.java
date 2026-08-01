package io.rafaelmacedo.rastreadorpedido.dto.response;

public record EnderecoEntregaResponse(
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}