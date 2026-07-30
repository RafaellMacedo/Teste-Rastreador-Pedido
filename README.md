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