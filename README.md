# 💸 FinancialTR - Financial Transaction Recorder API

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![JWT](https://img.shields.io/badge/Security-JWT-orange)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

> API robusta e segura para controle de transações financeiras, com autenticação baseada em JWT, uploads com AWS S3, e estrutura modularizada seguindo boas práticas REST.

---

## 🧠 Sobre o projeto

**FinancialTR** é uma API RESTful construída com Java + Spring Boot que permite usuários cadastrarem, consultarem e gerenciarem transações financeiras categorizadas por tipo, com total segurança, tratamento de erros personalizado e estrutura escalável.

💡 Esse projeto foi desenvolvido com o objetivo de:

- Aprender e aplicar arquitetura limpa e boas práticas REST;
- Trabalhar com autenticação e autorização usando JWT;
- Integrar envio de arquivos com AWS S3;
- Desenvolver um backend sólido que pode ser integrado com um front Angular (em desenvolvimento).

---

## 🔧 Tecnologias e ferramentas

- **Java 17**
- **Spring Boot 3**
- **Spring Security com JWT**
- **Spring Data JPA + PostgreSQL**
- **MapStruct** para mapeamento de DTOs
- **Lombok** para redução de boilerplate
- **Flyway** para versionamento de banco de dados
- **AWS S3** para upload de arquivos
- **Swagger/OpenAPI 3** para documentação
- **Exception Handling** centralizado
- **Arquitetura modularizada** em camadas: Controller, Service, Repository, DTO, Mapper, etc.

---

## 🔐 Autenticação & Segurança

- Login com e-mail e senha
- Geração de **JWT** com expiração
- Filtros de segurança configurados com `JwtAuthTokenFilter`
- Controle de acesso a endpoints via roles e autorização
- Endpoints protegidos via `@PreAuthorize`

---

## 📁 Estrutura de pacotes

```bash
com.app.financialTR
├── config              # Configurações gerais (Swagger, S3, Constantes)
├── controller          # Controllers REST
├── DTO                 # Data Transfer Objects
├── exceptions          # Tratamento customizado de erros
├── mapper              # MapStruct Mappers
├── model               # Entidades JPA
├── repository          # Interfaces JPA Repositories
├── response            # Objetos de resposta customizados
├── security            # Configurações de segurança e filtros JWT
├── service             # Regras de negócio
├── utils               # Utilitários diversos (JWT, paginação, etc.)
└── FinancialTrApplication.java

## 📌 Funcionalidades

✅ Cadastro e login de usuários  
✅ Geração de token JWT com expiração  
✅ Consulta de transações por categoria, data ou tipo  
✅ Upload de comprovantes para AWS S3  
✅ Tratamento de exceções personalizado (ex: usuário duplicado, credenciais inválidas, etc.)  
✅ Documentação Swagger UI disponível  
✅ Separação clara entre entidades e DTOs  

---

## 📖 Documentação Swagger

Acesse a documentação interativa dos endpoints em:  
🔗 `http://localhost:8080/swagger-ui/index.html`
