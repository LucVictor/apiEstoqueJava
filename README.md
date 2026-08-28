# apiEstoque

Aplicação backend em Java (Spring Boot) para gerenciamento de estoque.

**Resumo:**
- Projeto Maven que fornece endpoints para autenticação, gerenciamento de produtos, avarias, conferência e vencimentos.

**Pré-requisitos:**
- Java 17+
- Maven (ou use o wrapper `mvnw` / `mvnw.cmd`)

**Como executar (desenvolvimento):**

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

Ou construir o JAR e executar:

```bash
mvn clean package
java -jar target/estoque-0.0.1-SNAPSHOT.jar
```

**Testes:**

Executar testes unitários com:

```bash
mvn test
```

**Configuração:**
- As configurações de conexão com o banco e outras propriedades ficam em `src/main/resources/application.properties`.
- O projeto inclui suporte a `H2` (runtime) e `MySQL` (runtime). Use variáveis de ambiente ou ajuste `application.properties` conforme necessário.

**Estrutura principal:**
- `com.caico.estoque.controller` — Controladores REST
- `com.caico.estoque.service` — Lógica de negócio
- `com.caico.estoque.repository` — Repositórios JPA
- `com.caico.estoque.model` — Entidades de domínio
- `com.caico.estoque.security` — Configuração de segurança e JWT

**Licença:**
Este projeto está licenciado sob a Licença BSD 3-Clause — veja o arquivo [LICENSE](LICENSE) para o texto completo.


Arquivo gerado automaticamente.
