# 💸 FinancialTR - Financial Transaction Recorder API

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![JWT](https://img.shields.io/badge/Security-JWT-orange)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![AWS S3](https://img.shields.io/badge/AWS-S3-yellow)
![Flyway](https://img.shields.io/badge/Database_Versioning-Flyway-red)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

> API robusta e segura para controle de transações financeiras, com autenticação baseada em JWT, envio de e-mails automáticos, uploads com AWS S3, versionamento com Flyway e estrutura modularizada seguindo boas práticas REST.

---

## 🧠 Sobre o projeto

**FinancialTR** é uma API RESTful desenvolvida com Java e Spring Boot que permite aos usuários cadastrarem, consultarem e gerenciarem transações financeiras categorizadas, com segurança, modularidade e escalabilidade. O projeto está em evolução contínua e será integrado futuramente a um front-end em Angular.

---

## 🔧 Tecnologias e ferramentas

- **Java 17**
- **Spring Boot 3**
- **Spring Security com JWT**
- **Spring Data JPA + PostgreSQL**
- **Flyway** para versionamento de banco de dados
- **JavaMailSender** para envio de e-mails
- **MapStruct** para mapeamento de DTOs
- **Lombok** para redução de boilerplate
- **AWS S3** para upload de arquivos
- **Swagger/OpenAPI 3** para documentação
- **Tratamento centralizado de exceções**
- **Arquitetura modular em camadas**

---

## 📁 Estrutura de pacotes

```
com.app.financialTR
├── config
├── controller
├── DTO
├── exceptions
├── mapper
├── model
├── repository
├── response
├── security
├── service
├── utils
└── FinancialTrApplication.java
```

---

## 📌 Funcionalidades

✅ Cadastro e login de usuários com autenticação JWT  
✅ Geração de token com expiração usando Spring Security  
✅ Envio de e-mails automáticos com JavaMail (boas-vindas, redefinição de senha)  
✅ Consulta de transações por categoria, tipo e data  
✅ Upload de comprovantes para AWS S3  
✅ Versionamento automático do banco de dados com Flyway  
✅ Tratamento de exceções personalizado e mensagens amigáveis  
✅ Separação clara entre entidades e DTOs  
✅ Documentação Swagger UI para testes e integração  

---

## 📬 E-mails automáticos com Spring

O sistema envia e-mails para os usuários em momentos importantes, como:

- 📥 Confirmação de cadastro (boas-vindas)
- 🔄 Redefinição de senha com link seguro

---

## 📖 Documentação Swagger

Acesse a documentação interativa dos endpoints em:  
🔗 `http://localhost:8080/swagger-ui/index.html`

---
