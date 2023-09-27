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

## Conclusão

Este projeto adotou uma abordagem específica para implementar uma fila de atendimento para clientes e empresas, 
atendendo às regras de negócio da história de usuário. A decisão de implementar uma fila personalizada usando tipos de
 dados primitivos e manter filas separadas para cada tipo de entidade foi tomada para atender às necessidades específicas 
da aplicação. Além disso, a criação de endpoints dedicados para cada fila e a cobertura de testes unitários garantem que o código seja robusto e atenda aos requisitos estabelecidos.
