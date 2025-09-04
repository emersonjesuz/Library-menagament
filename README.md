# 📚 Projeto: Sistema de Gerenciamento de Biblioteca

Este é um projeto simples desenvolvido em **Java com Spring Boot** para treinar **lógica de programação** e aplicar *
*boas práticas de desenvolvimento de APIs REST**.

A API permite gerenciar **usuários** e **livros**, controlando empréstimos e devoluções.  
A documentação é feita com **Swagger**.

---

## 🎯 Objetivo

Criar uma API REST de gerenciamento de biblioteca, aplicando:

- Regras de negócio.
- Estruturas de dados.
- Boas práticas de modelagem.
- Documentação com Swagger.

---

## 🛠️ Funcionalidades

- 📌 **Livros**
    - Cadastrar livros.
    - Listar livros.
    - Verificar disponibilidade.
    - Emprestar e devolver livros.

- 👤 **Usuários**
    - Cadastrar usuários.
    - Listar usuários.
    - Regras:
        - Um usuário pode ter no máximo **3 livros emprestados**.
        - O **CPF** deve ser único.
        - O **ISBN** do livro deve ser único.

---

## 📂 Estrutura do Projeto

- `model` → Entidades principais (`Usuario`, `Livro`).
- `repository` → Acesso a dados.
- `service` → Regras de negócio.
- `controller` → Endpoints da API.

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- **Java 17+**
- **Maven**
- **PostgreSQL** (ou banco de sua escolha)

### Passos

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-biblioteca.git

2. Configure o arquivo application.properties ou application.yml com as credenciais do seu banco.
3. Rode a aplicação:
    ```bash
    mvn spring-boot:run

## 📖 Documentação da API

Acesse o Swagger para testar os endpoints:

👉 http://localhost:8080/swagger-ui.html

## 🧠 O que você treina com este projeto

- 🚀 Criação de APIs REST com Spring Boot.

- 📦 Uso de DTOs para entrada e saída de dados.

- ⚙️ Implementação de regras de negócio no service.

- 🏗️ Boas práticas de camadas (Controller, Service, Repository).

- 📝 Documentação automática com Swagger.

- 💾 Persistência com JPA / Hibernate.

## 📌 Próximos Desafios

- ⏰ Implementar sistema de multas para livros atrasados.

- 📑 Adicionar paginação e filtros nas listagens.

- 🔑 Criar autenticação com JWT.