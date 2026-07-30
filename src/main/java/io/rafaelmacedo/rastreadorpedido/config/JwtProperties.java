package io.rafaelmacedo.rastreadorpedido.config;

import org.springframework.stereotype.Component;

@Component
public class JwtProperties {
    public String secret = "minha-chave-super-secreta-jwt-rastreador-pedido";
    public long expiration = 3600000;
}