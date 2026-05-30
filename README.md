# Fraud Detection Microservice

Microsserviço em Spring Boot 3 e Java 17 projetado para analisar transações financeiras em tempo real e identificar fraudes instantaneamente.

## 🚀 Funcionalidades

- **Análise em Tempo Real:** Avaliação síncrona de transações recebidas por API REST.
- **Motor de Regras (Rule Engine):** Validações isoladas e desacopladas para fácil manutenção.
- **Regras Implementadas:**
  - Limite de valor por transação (`AmountLimitRule`).
  - Velocidade e frequência de compras consecutivas (`VelocityCheckRule`).

## 🛠️ Tecnologias Utilizadas

- **Java 17** & **Spring Boot 3.2.5**
- **Spring Data JPA** & **MySQL**
- **Lombok** (Eliminação de boilerplate)
- **MapStruct** (Mapeamento de DTOs para Entidades de alta performance)

## 🔧 Configuração e Execução

### 1. Banco de Dados
Configure as credenciais do seu MySQL no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todolist?createDatabaseIfNotExist=true
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
