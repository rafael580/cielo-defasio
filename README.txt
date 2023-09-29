## Bem-vindo ao repositório!

Esse projeto é o desafio final de programação do bootcamp da Cielo

## Autor:

 [<img src="https://media-exp1.licdn.com/dms/image/D4D35AQGOurLMwVfl6A/profile-framedphoto-shrink_400_400/0/1650557484845?e=2147483647&v=beta&t=xhWrsd65O_0bgpxiwcwwyIDHO46y2b7tSly8Kgil2zY" width=115><br><sub>Rafael Roco</sub>](https://www.linkedin.com/in/rafael-roco-0b7bb113b/)



## Como executar a aplicação:
1. Baixar ou clonar o projeto do Github.
2. Instalar o Java JDK (Versão 17 ou superior).
3. Instalar uma IDE que execute o JAVA da sua escolha.
4. Execute o Eclipse ou alguma IDE Java.
5. Importe o projeto para dentro da sua IDE como projeto Maven.
6. Execute a aplicação utilizando o Spring Boot App.
7. Instalar o Postman ou alguma plataforma de API da sua escolha.
8. Execute a plataforma de API e insira os EndPoints presentes no arquivo REQUEST.JSON do projeto.
9. Execute as requisições.
10. Acesse a documentação Swagger em http://localhost:8080/swagger-ui.html.



## Sprint's <br>
> Sprint 1       Status: Concluído ✅ <br><br>
> Sprint 2       Status: Concluído ✅ <br><br>
> Sprint 3       Status: Concluído ✅ <br><br>
> Sprint 4       Status: Concluído ✅ <br><br>





![Sprint 1](/images/SPT.jpg)
![Sprint 1](/images/SPRINT1.2.jpg)



# Desafio: API REST de Cadastro de Clientes

Este projeto foi desenvolvido como uma solução para o desafio de criar uma API REST para cadastro de clientes, com suporte para Pessoa Jurídica e Pessoa Física,
 validações de dados, tratamento de erros e testes unitários com JUnit 5. A seguir, explicarei o motivo da escolha de cada uma dessas soluções:

## Uso de DTO (Data Transfer Object)

### Motivação:
- Utilizamos DTOs para transferir dados entre as camadas da aplicação, como controladores e serviços. Isso ajuda a separar a representação dos dados do 
modelo de domínio, tornando o sistema mais flexível e evitando vazamento de informações sensíveis.

### Vantagens:
- Evita exposição de informações confidenciais.
- Facilita a validação e manipulação de dados de entrada.
- Reduz o acoplamento entre as camadas da aplicação.

## Bean Validation

### Motivação:
- A validação de dados é essencial para garantir que as informações fornecidas pelos usuários atendam aos requisitos do sistema. O Bean Validation
 é uma abordagem eficaz para definir regras de validação de forma declarativa.

### Vantagens:
- Permite a especificação de regras de validação diretamente nas classes de DTO, tornando-as autoexplicativas.
- Ajuda a evitar a persistência de dados inválidos no sistema.
- Facilita a manutenção das regras de validação.

## Tratamento de Erros

### Motivação:
- Tratar erros de forma adequada é fundamental para garantir a robustez e a usabilidade da aplicação. Os erros podem ocorrer em várias etapas,
 desde a validação de entrada até o processamento de dados.

### Vantagens:
- Fornece feedback claro ao usuário em caso de erro.
- Evita exposição de informações sensíveis nos erros.
- Contribui para uma melhor experiência do usuário.

## Arquitetura Limpa (Clean Architecture)

### Motivação:
- A adoção da arquitetura limpa ajuda a criar uma aplicação modular, testável e de fácil manutenção. Ela promove a separação de responsabilidades
 e a dependência de direção única.

### Vantagens:
- Facilita a evolução da aplicação, pois as camadas são desacopladas.
- Melhora a testabilidade, permitindo a substituição fácil de componentes.
- Torna o código mais organizado e compreensível.

## Testes Unitários com JUnit 5

### Motivação:
- Os testes unitários garantem que partes individuais do código funcionem conforme o esperado. Eles são essenciais para manter a qualidade do 
software e evitar regressões.

### Vantagens:
- Detecta erros precocemente, facilitando a correção.
- Documenta o comportamento esperado do código.
- Permite refatorações com confiança.

## EndPoints:
Os endpoints para teste e acesso ao seus métodos HTTPs (GET, POST, PUT e DELETE)  são:


### Endpoint do Cliente :

Faz a busca de todos os clientes e faz busca com filtragem

GET : http://localhost:8080/clientes?page=0&pageSize=1&direction=DESC&orderBy=name




