package io.rafaelmacedo.rastreadorpedido.dto.request;

public record EnderecoEntregaRequestDTO(
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cidade,
    String estado,
    String cep
) {
}
