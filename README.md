# Teste-Rastreador-Pedido

## O que fazer:

Back-end (obrigatório)

Autenticação (fluxo simples contendo):

- Cadastro de usuário (nome, e-mail e senha);
- Login utilizando e-mail e senha;
- Apenas usuários autenticados podem acessar o sistema;
- A forma de autenticação fica a seu critério.

API REST em Java + Spring Boot com endpoints para:

- Criar um pedido (cliente, itens, endereço de entrega);S
- Atualizar o status do pedido, considerando os status:
- RECEBIDO, EM_PREPARO, SAIU_PARA_ENTREGA, ENTREGUE e CANCELADO;
- Listar todos os pedidos e buscar um pedido por ID.

Persistência em SQLite ou similar.

Front-end (obrigatório)

- Aplicação em React que lista os pedidos com seus status atuais e permite criar um novo pedido.

curl -v -X POST http://localhost:8080/clientes \
-H "Content-Type: application/json" \
-d '{"nome":"Rafael","email":"teste@email.com","senha":"123456"}'
Note: Unnecessary use of -X or --request, POST is already inferred.
* Host localhost:8080 was resolved.
* IPv6: ::1
* IPv4: 127.0.0.1
*   Trying [::1]:8080...
* Connected to localhost (::1) port 8080
> POST /clientes HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.5.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 60
>
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 0
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Thu, 30 Jul 2026 18:37:06 GMT
<
* Connection #0 to host localhost left intact
  {"id":1,"nome":"Rafael","email":"teste@email.com","senha":"$2a$10$KMXuezK10F1ZLeO87D6pDuBti/y9LLZW83WlV0pwJaSETkdercwxO"}