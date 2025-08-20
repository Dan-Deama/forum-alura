# 📚 Forum Alura

Este é um projeto de API REST desenvolvido com **Spring Boot**, voltado para a criação de um fórum de discussão. Ele inclui autenticação JWT, migração de banco de dados com Flyway e organização modular por domínio.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Flyway
- MySQL
- Maven

## 📁 Estrutura do Projeto

<pre><code>
   forum-alura/
   ├── src/
   │   ├── main/
   │   │   ├── java/
   │   │   │   └── br/com/alura/forum/
   │   │   │       ├── config/
   │   │   │       │   └── ModelMapperConfig.java
   │   │   │       ├── controller/
   │   │   │       │   └── AutenticacaoController.java
   │   │   │       ├── domain/
   │   │   │       │   ├── perfil/
   │   │   │       │   ├── resposta/
   │   │   │       │   ├── topico/
   │   │   │       │   └── usuario/
   │   │   │       ├── infra/security/
   │   │   │       │   ├── DadosTokenJWT.java
   │   │   │       │   ├── SecurityConfigurations.java
   │   │   │       │   ├── SecurityFilter.java
   │   │   │       │   └── TokenService.java
   │   │   │       └── ForumAluraApplication.java
   │   │   └── resources/
   │   │       ├── db/migration/
   │   │       │   └── v1__create-tables.sql
   │   │       └── application.properties
   │   └── test/</code></pre>


## ⚙️ Configurações (`application.properties`)

```properties
spring.application.name=forum-alura
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=never

api.security.token.secret=umaChaveSecretaLonga
````

## 🧪 Como Executar
- Clone o repositório:
git clone https://github.com/Dan-Deama/forum-alura.git
cd forum-alura
- Configure o banco de dados MySQL com o nome forumhub.
- Atualize o application.properties com suas credenciais.
- Execute o projeto:
./mvnw spring-boot:run


## 🔐 Autenticação
O projeto utiliza autenticação baseada em JWT. Após o login via AutenticacaoController, o token é gerado e deve ser incluído no header Authorization para acessar endpoints protegidos.



