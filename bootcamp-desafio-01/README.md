# Desafio: API REST de Cadastro de Clientes

Este projeto foi desenvolvido como uma solução para o desafio de criar uma API REST para cadastro de clientes, com suporte para Pessoa Jurídica e Pessoa Física, validações de dados, tratamento de erros e testes unitários com JUnit 5. A seguir, explicarei o motivo da escolha de cada uma dessas soluções:

## Uso de DTO (Data Transfer Object)

### Motivação:
- Utilizamos DTOs para transferir dados entre as camadas da aplicação, como controladores e serviços. Isso ajuda a separar a representação dos dados do modelo de domínio, tornando o sistema mais flexível e evitando vazamento de informações sensíveis.

### Vantagens:
- Evita exposição de informações confidenciais.
- Facilita a validação e manipulação de dados de entrada.
- Reduz o acoplamento entre as camadas da aplicação.

## Bean Validation

### Motivação:
- A validação de dados é essencial para garantir que as informações fornecidas pelos usuários atendam aos requisitos do sistema. O Bean Validation é uma abordagem eficaz para definir regras de validação de forma declarativa.

### Vantagens:
- Permite a especificação de regras de validação diretamente nas classes de DTO, tornando-as autoexplicativas.
- Ajuda a evitar a persistência de dados inválidos no sistema.
- Facilita a manutenção das regras de validação.

## Tratamento de Erros

### Motivação:
- Tratar erros de forma adequada é fundamental para garantir a robustez e a usabilidade da aplicação. Os erros podem ocorrer em várias etapas, desde a validação de entrada até o processamento de dados.

### Vantagens:
- Fornece feedback claro ao usuário em caso de erro.
- Evita exposição de informações sensíveis nos erros.
- Contribui para uma melhor experiência do usuário.

## Arquitetura Limpa (Clean Architecture)

### Motivação:
- A adoção da arquitetura limpa ajuda a criar uma aplicação modular, testável e de fácil manutenção. Ela promove a separação de responsabilidades e a dependência de direção única.

### Vantagens:
- Facilita a evolução da aplicação, pois as camadas são desacopladas.
- Melhora a testabilidade, permitindo a substituição fácil de componentes.
- Torna o código mais organizado e compreensível.

## Testes Unitários com JUnit 5

### Motivação:
- Os testes unitários garantem que partes individuais do código funcionem conforme o esperado. Eles são essenciais para manter a qualidade do software e evitar regressões.

### Vantagens:
- Detecta erros precocemente, facilitando a correção.
- Documenta o comportamento esperado do código.
- Permite refatorações com confiança.

Executando o Projeto
Para executar o projeto localmente, siga estas etapas:

Clone o repositório do GitHub.
Certifique-se de ter o Java e o Maven instalados em sua máquina.
Navegue até o diretório raiz do projeto.
Execute o comando mvn spring-boot:run para iniciar a aplicação.
Acesse a documentação Swagger em http://localhost:8080/swagger-ui.html.