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


#### 🟢 GET - Consultar todas os clientes

Faz a busca de todos os clientes e faz busca com filtragem

GET : http://localhost:8080/clientes?page=0&pageSize=1&direction=DESC&orderBy=name


![Sprint 1](/images/clientesget.jpg)


#### 🟢 GET - Consultar um cliente 


GET: http://localhost:8080/clientes/{id}


![Sprint 1](/images/clientesid.jpg)



#### 🟡 POST - Criar um cliente

POST: http://localhost:8080/clientes

{<br>
    <br>"mcc":"0003",<br>
   <br> "cpf":"11625739619",<br>
    <br>"nome": "rafael roco",<br>
    <br>"email": "rafae.dev@mail.com"<br>
}<br>


![Sprint 1](/images/clientespost.jpg)





#### 🔵  PUT - Atualizar dados do cliente

PUT: http://localhost:8080/clientes/{id}

{<br>
    <br> "mcc":"0001",<br>
     <br>"cpf":"99625739991",<br>
     <br>"nome": "rafael roco",<br>
    <br> "email": "rafae.dev@mail.com"<br>
}<br>

![Sprint 1](/images/clientesput.jpg)



#### 🔴 DELETE - Deletar um cliente


DELETE: http://localhost:8080/clientes/{id}


![Sprint 1](/images/deletecliente.jpg)




### Endpoint da Empresa :




#### 🟢 GET - Consultar todas as empresas

Faz a busca de todos os clientes e faz busca com filtragem

GET : http://localhost:8080/empresas


![Sprint 1](/images/empresas.jpg)


#### 🟢 GET - Consultar uma empresa


GET: http://localhost:8080/empresas/{id}


![Sprint 1](/images/empresaid.jpg)


#### 🟡 POST - Criar uma empresa

POST: http://localhost:8080/empresas

{<br>
      	   <br> "cnpj": "93412444322111",<br>
          <br>  "razaoSocial": "rafael",<br>
         <br>   "mcc": "0003",<br>
          <br>  "cpf": "23412449922",<br>
         <br>   "contratoEstabelecido": "contrato teste",<br>
          <br>  "emailEstabelecido": "emprea@gmail.com"<br>
}<br>


![Sprint 1](/images/empresapost.jpg)





#### 🔵  PUT - Atualizar dados de uma empresa

PUT: http://localhost:8080/empresas/{id}

{<br>
           <br> "cnpj": "23412444322111",<br>
          <br>  "razaoSocial": "rafael",<br>
          <br>  "mcc": "0003",<br>
          <br>  "cpf": "23412444422",<br>
         <br>   "contratoEstabelecido": "contrato teste",<br>
         <br>   "emailEstabelecido": "emprega@gmail.com"<br>
}<br>

![Sprint 1](/images/empresaput.jpg)



#### 🔴 DELETE - Deletar uma empresa

DELETE: http://localhost:8080/empresas/{id}


![Sprint 1](/images/empresadelete.jpg)

<br>
<br>
<br>
<br>
<br>
<br>

![Sprint 2](/images/desafio1.jpg)



# Desafio: Implementação de Fila de Atendimento em uma API

Este projeto tem como objetivo atender a uma história de usuário específica que requer a implementação de uma fila de 
atendimento para clientes prospect na área de Comercialização da Cielo. A fila deve seguir as regras especificadas na história de usuário.
 Além disso, foram tomadas decisões de design específicas, explicadas a seguir:

## Implementação de Fila Personalizada

### Motivação
- Para atender às regras de negócio da história de usuário, optou-se por implementar uma fila personalizada usando 
tipos de dados primitivos em vez de utilizar as classes de fila disponíveis na biblioteca `java.util.*`.

### Vantagens
- Controle mais granular: Implementar uma fila personalizada permite um maior controle sobre como os elementos são adicionados 
e removidos da fila, o que é importante para atender às regras específicas de entrada e saída.
- Redução de dependências: Reduz a dependência de bibliotecas externas, mantendo o código mais leve e simples.
- Maior entendimento: A implementação personalizada da fila pode ser mais clara e específica em relação aos requisitos do sistema.

## Fila Separada para Clientes e Empresas

### Motivação
- Cada tipo de entidade (cliente e empresa) tem requisitos e características diferentes, incluindo a forma como são adicionados à fila e tratados.

### Vantagens
- Separação de preocupações: Ao manter filas separadas para clientes e empresas, é possível lidar com cada tipo de entidade de forma isolada, facilitando a manutenção e expansão futura.
- Flexibilidade: Se as regras de negócio para clientes e empresas divergirem no futuro, as filas separadas podem ser modificadas independentemente.

## Implementação de Endpoints Específicos

### Motivação
- Para cumprir a história de usuário, foi necessário criar endpoints específicos para lidar com a fila de atendimento para clientes e empresas.

### Vantagens
- Clareza e foco: Cada endpoint tem uma responsabilidade específica, tornando o código mais claro e fácil de entender.
- Flexibilidade: Se os requisitos para a fila de clientes e empresas mudarem no futuro, é possível adaptar os endpoints independentemente.

## Cobertura de Testes Unitários

### Motivação
- Testar o código é fundamental para garantir que ele funcione conforme o esperado e para facilitar futuras alterações e expansões.

### Vantagens
- Confiança: Os testes unitários garantem que o código esteja funcionando corretamente, evitando regressões.
- Documentação viva: Os testes servem como documentação viva do comportamento do código, facilitando a compreensão para outros desenvolvedores.


## EndPoint:
Os endpoints para teste e acesso ao seu método HTTPs (GET)  são:

### Endpoint da Cliente:


#### 🟢 GET - Consultar FILA CHEIA

Faz a busca de todos os clientes e faz busca com filtragem

http://localhost:8080/clientes/primeiro-da-fila-cliente

![Sprint 2](/images/clientecheio.jpg)


#### 🟢 GET - Consultar FILA VAZIA


http://localhost:8080/clientes/primeiro-da-fila-cliente


![Sprint 2](/images/clientevazio.jpg)


### Endpoint da Empresa:


#### 🟢 GET - Consultar FILA CHEIA

Faz a busca de todos os clientes e faz busca com filtragem

http://localhost:8080/empresas/primeiro-da-fila-empresa

![Sprint 2](/images/empresacheia.jpg)


#### 🟢 GET - Consultar FILA VAZIA


http://localhost:8080/empresas/primeiro-da-fila-empresa


![Sprint 2](/images/empresavazia.jpg)

<br>
<br>
<br>
<br>

![Sprint 3](/images/desafio3.jpg)


<br>
<br>



# Fila de Atendimento com AWS SQS

Este projeto descreve a implementação de uma fila de atendimento compartilhada entre clientes e empresas utilizando o Amazon Simple Queue Service (SQS) da AWS.

## Motivação
### Problema de Escalabilidade
Identificamos a necessidade de uma solução robusta para lidar com o crescimento da fila de atendimento, que agora inclui tanto clientes quanto empresas.

### Perda de Dados
A aplicação original armazenava dados de clientes e empresas em memória, resultando na perda de dados ao reiniciar a aplicação.

## Vantagens do Amazon SQS
- **Elasticidade:** O SQS é altamente escalável, adaptando-se automaticamente às demandas sem necessidade de provisionamento manual.
- **Persistência de Dados:** Mensagens na fila SQS são armazenadas de forma durável e segura.
- **Alta Disponibilidade:** O SQS é gerenciado pela AWS e oferece alta disponibilidade.
- **Integração com a AWS:** Permite integração com outras soluções AWS, como AWS Lambda, Amazon S3 e Amazon EC2.


## EndPoint CLIENTE:

Os endpoints para teste e acesso aos seu métodos HTTPs (POST,PUT)  são:

#### 🟡 POST - Criar um cliente


POST: http://localhost:8080/clientes

{<br>
    <br>"mcc":"0003",<br>
   <br> "cpf":"11625739619",<br>
    <br>"nome": "rafael roco",<br>
    <br>"email": "rafae.dev@mail.com"<br>
}<br>


![Sprint 3](/images/clientespost3.jpg)

Resultado 

![Sprint 3](/images/resultadopost3.jpg)

#### 🔵  PUT - Atualizar dados do cliente

PUT: http://localhost:8080/clientes/{id}

{<br>
    <br> "mcc":"0001",<br>
     <br>"cpf":"99625739991",<br>
     <br>"nome": "rafael roco",<br>
    <br> "email": "rafae.dev@mail.com"<br>
}<br>

![Sprint 1](/images/clientesput3.jpg)

Resultado 

![Sprint 3](/images/resultadoput3.jpg)


## EndPoint EMPRESA

Os endpoints para teste e acesso aos seu métodos HTTPs (POST,PUT)  são:


POST: http://localhost:8080/empresas

{<br>
   	  <br>  "cnpj": "93412444322111",<br>
          <br>  "razaoSocial": "rafael",<br>
          <br>  "mcc": "0003",<br>
          <br>  "cpf": "23412449922",<br>
          <br>  "contratoEstabelecido": "contrato teste",<br>
          <br>  "emailEstabelecido": "emprea@gmail.com"<br>
}<br>


![Sprint 3](/images/empresasqs.jpg)

Resultado 

![Sprint 3](/images/empresasqs3.jpg)

#### 🔵  PUT - Atualizar dados do cliente

PUT: http://localhost:8080/empresas/{id}

{<br>
    <br> "mcc":"0001",<br>
     <br>"cpf":"99625739991",<br>
     <br>"nome": "rafael roco",<br>
    <br> "email": "rafae.dev@mail.com"<br>
}<br>

![Sprint 3](/images/sqsempresa.jpg)

Resultado 

![Sprint 3](/images/sqsempresa3.jpg)

<br>
<br>
<br>
<br>
<br>
<br>

![Sprint 4](/images/desafio4.jpg)


# Uso do JWT para Melhorar a Segurança da Informação

## Introdução

Este readme explica como o uso de JSON Web Tokens (JWT) pode ser benéfico para melhorar a segurança da informação em uma aplicação. Abordaremos os seguintes pontos:

- Identificação de um débito técnico de Segurança da Informação na aplicação.
- Detalhamento do débito técnico identificado, incluindo criticidade e possíveis consequências.
- Planejamento das atividades técnicas para o desenvolvimento da solução.
- Implementação da solução utilizando JWT.

## a) Identificação de um débito técnico de Segurança da Informação

**Débito Técnico:** A aplicação atual não utiliza autenticação e autorização adequadas para proteger o acesso a recursos e informações sensíveis.

## b) Detalhamento do débito técnico

**Criticidade:** Alta

**Possíveis Consequências:**
1. **Vazamento de Dados:** Sem autenticação, qualquer usuário pode acessar informações confidenciais.
2. **Integridade Comprometida:** Os dados podem ser modificados por usuários não autorizados.
3. **Acesso não Autorizado:** Usuários mal-intencionados podem executar ações não permitidas.
4. **Não Rastreabilidade:** A falta de autenticação torna difícil rastrear quem acessou os recursos.

## c) Planejamento das atividades técnicas para a solução

Para solucionar esse débito técnico e melhorar a segurança da informação, podemos seguir estas etapas:

**1. Implementação da Autenticação e Autorização:**

- Utilizar JWT (JSON Web Tokens) para autenticar usuários.
- Definir papéis e permissões para os usuários (por exemplo, admin, usuário regular).
- Criar um sistema de gerenciamento de sessões.

**2. Configuração de Expiração e Renovação:**

- Definir tempos de expiração para os tokens JWT para limitar o acesso.
- Implementar renovação de tokens para evitar que os usuários sejam desconectados frequentemente.

**3. Proteção de Recursos Sensíveis:**

- Garantir que apenas usuários autenticados e autorizados tenham acesso a recursos sensíveis.
- Implementar controle de acesso baseado em papéis para garantir que apenas usuários com permissões adequadas possam executar ações específicas.

**4. Monitoramento e Registro:**

- Implementar registros de auditoria para rastrear atividades de usuários.
- Configurar alertas para atividades suspeitas.

## d) Implementação da solução

A implementação da solução envolverá o desenvolvimento de:

- Um sistema de autenticação que emite tokens JWT após a autenticação do usuário.
- Um sistema de autorização que verifica as permissões do usuário com base no token JWT.
- Controles de acesso a recursos sensíveis para garantir que apenas usuários autorizados possam acessá-los.
- Configuração de expiração e renovação de tokens JWT para gerenciar o tempo de acesso dos usuários.
- Registros de auditoria para monitorar e rastrear atividades de usuários.



