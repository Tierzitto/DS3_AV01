# Automanager

Micro-serviço desenvolvido em Spring Boot para gerenciamento e cadastro de dados de clientes, incluindo endereços, documentos e telefones.

## Tecnologias

- Java 21
- Spring Boot (2.6.3)
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Dados Iniciais (Seed)

Ao iniciar a aplicação, um cliente padrão é cadastrado automaticamente:
- **Dom Pedro** (ID: 1)

## Endpoints da API

Todas as operações retornam respostas estruturadas com mensagens descritivas e status HTTP apropriados (`200 OK`, `201 Created`, `404 Not Found`).

- `GET /cliente/clientes`: Lista todos os clientes cadastrados.
- `GET /cliente/{id}`: Obtém um cliente específico pelo ID.
- `POST /cliente/cadastro`: Cadastra um novo cliente.
- `PUT /cliente/atualizar`: Atualiza os dados de um cliente existente.
- `DELETE /cliente/excluir`: Exclui um cliente (via corpo da requisição).
- `DELETE /cliente/excluir/{id}`: Exclui um cliente pelo ID na URL.

## Execução

Para executar o projeto utilizando o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Para executar os testes:

```bash
./mvnw test
```
