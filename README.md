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

## 📄 Sobre este projeto

Este projeto foi desenvolvido como parte de um desafio técnico para um processo seletivo de Desenvolvedor Java.

O objetivo foi implementar uma API REST completa para gerenciamento de clientes, produtos e pedidos, utilizando Java e Spring Boot, aplicando conceitos de autenticação com JWT, arquitetura em camadas, tratamento de exceções, persistência com JPA/Hibernate e boas práticas de desenvolvimento.

Após a conclusão do desafio, o projeto continuou evoluindo e passou a fazer parte do meu portfólio pessoal, servindo como demonstração prática dos meus conhecimentos em desenvolvimento Backend.

O projeto foi desenvolvido seguindo boas práticas utilizadas em aplicações corporativas, como:

- Arquitetura em camadas
- DTOs para Request e Response
- Mapper para conversão entre entidades e DTOs
- Tratamento global de exceções
- Autenticação com JWT
- Criptografia de senhas utilizando BCrypt
- Spring Security
- JPA/Hibernate
- SQLite
- Validação de regras de negócio
- Validação de transição de status dos pedidos
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

# 🔗 Projetos Relacionados

Este projeto faz parte de uma aplicação completa desenvolvida por mim, composta por um frontend em React e uma API REST em Spring Boot. Ambos foram criados inicialmente para atender a um teste técnico de um processo seletivo e, atualmente, são mantidos como parte do meu portfólio para demonstrar conhecimentos em arquitetura de software, desenvolvimento full stack e integração entre aplicações.

| Projeto                                 | Descrição                                                                                                                                                                            |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [**Frontend - Rastreador de Pedidos**](https://github.com/RafaellMacedo/rastreador-pedido-frontend)    | Interface web desenvolvida com React, TypeScript, Material UI e React Router, responsável pela autenticação dos usuários e gerenciamento dos pedidos através do consumo da API REST. |
| [**Backend - Rastreador de Pedidos API**](https://github.com/RafaellMacedo/Teste-Rastreador-Pedido/) | API REST desenvolvida com Spring Boot, Spring Security, JWT Authentication, JPA/Hibernate e SQLite, responsável pelas regras de negócio, autenticação e persistência dos dados.      |

### Arquitetura da Solução

```text
┌─────────────────────────────┐
│     Frontend (React)        │
│ React + TypeScript + MUI    │
└──────────────┬──────────────┘
               │ HTTP / JSON
               ▼
┌─────────────────────────────┐
│   Backend (Spring Boot)     │
│ REST API + JWT + JPA         │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│         SQLite              │
└─────────────────────────────┘
```

Os dois projetos podem ser utilizados de forma independente para estudo ou em conjunto para demonstrar uma aplicação Full Stack completa, incluindo autenticação, consumo de APIs REST, gerenciamento de estado, navegação protegida e persistência de dados.

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
            │   ├── auth
            │   ├── request
            │   └── response
            ├── exception
            ├── mapper
            ├── model
            ├── repository
            ├── security
            └── service
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
- Login utilizando e-mail e senha
- Senhas criptografadas com BCrypt
- Autenticação utilizando JWT

---

## Produtos

- Cadastro de produtos
- Listagem de produtos

---

## Pedidos

- Criação de pedidos
- Associação de cliente
- Associação de endereço de entrega
- Associação de itens do pedido
- Listagem de pedidos
- Busca de pedido por ID
- Atualização de status
- Validação das transições de status

Status suportados:

- RECEBIDO
- EM_PREPARO
- SAIU_PARA_ENTREGA
- ENTREGUE
- CANCELADO

---

## Segurança

- Spring Security
- JWT Authentication
- BCrypt Password Encoder
- UserDetailsService
- JwtAuthenticationFilter
- Rotas públicas e protegidas

---

## Tratamento de exceções

Foi implementado tratamento global utilizando:

- @RestControllerAdvice
- Exceções customizadas
- Respostas padronizadas
- Validação de DTOs
- Tratamento para status inválidos
- Tratamento para transições inválidas de status

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

## Autenticação

| Método | Endpoint |
|---------|----------|
| POST | /auth/login |

---

## Clientes

| Método | Endpoint |
|---------|----------|
| POST | /clientes |

---

## Produtos

| Método | Endpoint |
|---------|----------|
| POST | /produtos |
| GET | /produtos |

---

## Pedidos

| Método | Endpoint |
|---------|----------|
| POST | /pedidos |
| GET | /pedidos |
| GET | /pedidos/{id} |
| PATCH | /pedidos/{id}/status |
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

# 📋 Regras de negócio

- O cliente deve existir para criar um pedido.
- Todo pedido é criado com status **RECEBIDO**.
- O pedido possui endereço de entrega.
- O pedido possui um ou mais itens.
- Apenas transições válidas de status são permitidas.
- Após um pedido ser **ENTREGUE** ou **CANCELADO**, seu status não pode mais ser alterado.

--- 

# 🛣️ Roadmap

- [x] Estrutura inicial do projeto
- [x] Spring Security
- [x] Cadastro de clientes
- [x] JWT Authentication
- [x] Login
- [x] SQLite
- [x] Cadastro de produtos
- [x] Listagem de produtos
- [x] Criação de pedidos
- [x] Listagem de pedidos
- [x] Busca de pedido por ID
- [x] Atualização de status
- [x] Validação das regras de negócio
- [x] Exception Handler Global
- [ ] Front-end React

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

Este projeto foi desenvolvido como parte de um desafio técnico para um processo seletivo, com o objetivo de demonstrar conhecimentos em desenvolvimento Backend utilizando Java, Spring Boot, Spring Security, JWT e boas práticas de arquitetura de software.

O código permanece disponível para fins de estudo, aprendizado e demonstração de portfólio.
