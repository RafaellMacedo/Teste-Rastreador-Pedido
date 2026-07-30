<div align="center">

# 📦 Rastreador de Pedidos API

API REST desenvolvida com **Spring Boot 4**, **Spring Security**, **JWT Authentication**, **JPA/Hibernate** e **SQLite**, com arquitetura em camadas e foco em boas práticas de desenvolvimento Backend.

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-7.1.0-6DB33F?style=for-the-badge&logo=springsecurity)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-7.4-Brown?style=for-the-badge&logo=hibernate)
![SQLite](https://img.shields.io/badge/SQLite-3-blue?style=for-the-badge&logo=sqlite)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

</div>

---

# 📖 Sobre o projeto

O objetivo deste projeto é construir uma API REST completa para gerenciamento de clientes e autenticação utilizando as principais tecnologias do ecossistema Java.

O projeto está sendo desenvolvido seguindo boas práticas utilizadas em aplicações corporativas, como:

- Arquitetura em camadas
- DTOs para Request e Response
- Tratamento global de exceções
- Autenticação com JWT
- Criptografia de senhas utilizando BCrypt
- Spring Security
- JPA/Hibernate
- SQLite
- Validação de regras de negócio

---

# 🚀 Tecnologias

- Java 21
- Spring Boot 4
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JSON Web Token)
- SQLite
- Maven
- Lombok

---

# 📂 Estrutura do projeto

```
src
└── main
    └── java
        └── io.rafaelmacedo.rastreadorpedido
            ├── config
            ├── controller
            ├── dto
            │   ├── request
            │   └── response
            ├── entity
            ├── exception
            ├── repository
            ├── security
            ├── service
            └── util
```

---

# 🔐 Autenticação

A autenticação da API utiliza **JWT (JSON Web Token)**.

Fluxo:

```
Cliente
    │
    ▼
POST /auth/login
    │
    ▼
Validação de Email + Senha
    │
    ▼
JWT Token
    │
    ▼
Authorization: Bearer {token}
    │
    ▼
Rotas protegidas
```

As senhas são armazenadas utilizando **BCrypt**, garantindo que nunca sejam persistidas em texto puro.

---

# 📦 Funcionalidades implementadas

## Clientes

- Cadastro de clientes
- Busca por e-mail
- Persistência utilizando SQLite
- DTOs de Request e Response

---

## Segurança

- Spring Security
- Login utilizando JWT
- PasswordEncoder (BCrypt)
- UserDetailsService
- JwtAuthenticationFilter
- Rotas públicas e protegidas

---

## Tratamento de exceções

Foi implementado um tratamento global de exceções utilizando:

- `@RestControllerAdvice`
- Exceções customizadas
- Respostas padronizadas

Exemplo:

```json
{
    "timestamp":"2026-07-30T16:45:00",
    "status":401,
    "message":"Invalid email or password"
}
```

---

# 📌 Endpoints

## Criar cliente

```
POST /clientes
```

Body

```json
{
    "nome":"Rafael Macedo",
    "email":"rafael@email.com",
    "senha":"123456"
}
```

Resposta

```json
{
    "id":1,
    "nome":"Rafael Macedo",
    "email":"rafael@email.com"
}
```

---

## Login

```
POST /auth/login
```

Body

```json
{
    "email":"rafael@email.com",
    "senha":"123456"
}
```

Resposta

```json
{
    "token":"eyJhbGc..."
}
```

---

## Rotas protegidas

Após realizar o login, envie o token no Header:

```
Authorization: Bearer eyJhbGc...
```

---

# 🔒 Regras de segurança

- Senhas criptografadas com BCrypt
- JWT com autenticação Stateless
- Rotas públicas:
    - POST /clientes
    - POST /auth/login
- Demais rotas protegidas por autenticação

---

# ⚙️ Executando o projeto

Clone o repositório

```bash
git clone https://github.com/RafaellMacedo/rastreador-pedido.git
```

Entre na pasta

```bash
cd rastreador-pedido
```

Execute

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

A API estará disponível em

```
http://localhost:8080
```

---

# 📋 Exemplo utilizando cURL

Cadastro

```bash
curl --location 'http://localhost:8080/clientes' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Rafael Macedo",
    "email":"rafael@email.com",
    "senha":"123456"
}'
```

---

Login

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "email":"rafael@email.com",
    "senha":"123456"
}'
```

---

# 🛣️ Roadmap

- [x] Estrutura inicial do projeto
- [x] Spring Security
- [x] Cadastro de clientes
- [x] DTOs
- [x] SQLite
- [x] PasswordEncoder
- [x] JWT Authentication
- [x] Login
- [x] Exception Handler Global
- [ ] CRUD de Pedidos
- [ ] CRUD de Produtos
- [ ] Refresh Token
- [ ] Swagger/OpenAPI
- [ ] Testes Unitários
- [ ] Testes de Integração
- [ ] Docker
- [ ] CI/CD

---

# 👨‍💻 Autor

**Rafael Macedo**

- Backend Java Developer
- Spring Boot
- Spring Security
- Microservices
- Docker

GitHub:
https://github.com/RafaellMacedo

LinkedIn:
https://www.linkedin.com/in/rafaellmacedo/

---

## 📄 Licença

Este projeto foi desenvolvido para fins de estudo, prática e demonstração de conhecimentos em desenvolvimento Backend utilizando Java e Spring Boot.

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