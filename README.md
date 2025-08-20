# FORUM HUB API

API REST desenvolvida em Spring Boot para gerenciamento de tópicos de fórum, com autenticação JWT e operações CRUD completas.

## Tecnologias

- Java 17  
- Spring Boot 3.x  
- Spring Security  
- Spring Data JPA (Hibernate)  
- Banco de dados SQL (H2/PostgreSQL)  
- JWT (JSON Web Token)  
- Maven ou Gradle  

## Pré-requisitos

- JDK 17 instalado  
- Maven (ou Gradle) configurado no PATH  
- Banco de dados configurado em `application.properties`  

## Configuração

1. Clone o repositório:  
   ```bash
   [git clone https://github.com/seu-usuario/topicos-api.git](https://github.com/Dan-Deama/forum-alura.git)
```
```
2. Edite os campos do Application.properties
````
spring.datasource.url=jdbc:postgresql://localhost:5432/topicosdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

jwt.secret=umaChaveSecretaLonga
jwt.expiration=3600000
````

## Tecnologias
Java 17+
Spring Boot
Spring Data JPA / Hibernate
PostgreSQL
Maven
Lombok
JWT

## Funcionalidades
Cadastrar usuarios
Fazer login
criar tópicos


