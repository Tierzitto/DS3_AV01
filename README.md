# Automanager

Micro-serviço desenvolvido em Spring Boot para gerenciamento e cadastro de dados de clientes, incluindo endereços, documentos e telefones.

## Tecnologias

- Java 21
- Spring Boot (2.6.3)
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Passo a Passo para Executar o Projeto

Siga os passos abaixo para clonar e rodar a aplicação localmente:

### 1. Pré-requisitos
Certifique-se de ter instalado em sua máquina:
- **Java Development Kit (JDK 21)**
- **Git**

### 2. Clonar o Repositório
Abra o terminal e execute o comando abaixo para clonar o repositório `DS3_AV01`:

```bash
git clone https://github.com/Tierzitto/DS3_AV01.git
```

Em seguida, navegue até a pasta do projeto:

```bash
cd DS3_AV01
```

### 3. Executar a Aplicação
Utilize o Maven Wrapper incluído no projeto para iniciar o servidor Spring Boot:

No **Linux / macOS**:
```bash
./mvnw spring-boot:run
```

No **Windows** (Prompt de Comando ou PowerShell):
```cmd
mvnw.cmd spring-boot:run
```

### 4. Executar os Testes Automatizados
Para validar o funcionamento executando os testes unitários e de contexto:

No **Linux / macOS**:
```bash
./mvnw test
```

No **Windows**:
```cmd
mvnw.cmd test
```

## Endpoints da API

Todas as operações retornam respostas estruturadas com mensagens descritivas e status HTTP apropriados (`200 OK`, `201 Created`, `404 Not Found`).

- `GET /cliente/clientes`: Lista todos os clientes cadastrados.
- `GET /cliente/{id}`: Obtém um cliente específico pelo ID.
- `POST /cliente/cadastro`: Cadastra um novo cliente.
- `PUT /cliente/atualizar`: Atualiza os dados de um cliente existente.
- `DELETE /cliente/excluir`: Exclui um cliente (via corpo da requisição).
- `DELETE /cliente/excluir/{id}`: Exclui um cliente pelo ID na URL.
