# Desafio: Implementação de Fila de Atendimento com AWS SQS

Este projeto tem como objetivo resolver um problema de escalabilidade identificado na fila de atendimento criada anteriormente, bem como melhorar a persistência de dados e garantir alta disponibilidade. A solução escolhida é utilizar o Amazon Simple Queue Service (SQS) da AWS para a gestão das filas de atendimento. A seguir, explicarei as razões para essa escolha:

## Utilização do Amazon SQS

### Motivação:
- O problema de escalabilidade identificado revelou a necessidade de uma solução mais robusta para a fila de atendimento.
- A aplicação originalmente armazenava os dados dos clientes e empresas em memória, o que resultava na perda de dados ao reiniciar a aplicação.

### Vantagens do Amazon SQS:
- **Elasticidade:** O Amazon SQS é altamente escalável. Ele pode lidar com grandes volumes de mensagens e se ajusta automaticamente às demandas, sem a necessidade de provisionamento manual de novas instâncias da aplicação.
- **Persistência de Dados:** As mensagens na fila SQS são armazenadas de forma durável e segura, garantindo que os dados dos clientes e empresas não sejam perdidos ao reiniciar a aplicação.
- **Alta Disponibilidade:** O SQS é uma solução gerenciada pela AWS que oferece alta disponibilidade. As mensagens são replicadas em várias zonas de disponibilidade, garantindo a resiliência contra falhas.
- **Integração com a AWS:** O Amazon SQS se integra perfeitamente com outras soluções da AWS, como AWS Lambda, Amazon S3 e Amazon EC2, facilitando a construção de pipelines de processamento de dados escaláveis.

## Implementação de Filas Separadas

### Motivação:
- Manter as filas separadas para clientes e empresas ainda é importante para atender às necessidades específicas de cada tipo de entidade.

### Vantagens:
- **Separação de Preocupações:** Cada fila continua a lidar com um tipo de entidade específico, mantendo a separação de preocupações e permitindo a flexibilidade para requisitos futuros distintos para clientes e empresas.

## Cada Fila com Endpoint Diferente

### Motivação:
- Manter endpoints separados para cada fila de atendimento continua a garantir a clareza e a simplicidade na implementação da API.
- Cada tipo de entidade tem requisitos diferentes, e manter endpoints dedicados torna mais fácil adicionar ou modificar funcionalidades específicas para cada fila.

### Vantagens:
- **Clareza e Foco:** Cada endpoint tem uma responsabilidade específica, facilitando a manutenção e o entendimento do código.
- **Flexibilidade:** Caso os requisitos para clientes e empresas mudem no futuro, é possível adaptar os endpoints independentemente.

## Conclusão

A utilização do Amazon SQS como solução de fila de atendimento resolve os problemas de escalabilidade, persistência de dados e alta disponibilidade identificados no desafio. Além disso, a manutenção de filas separadas e endpoints dedicados continua a atender às necessidades específicas de cada tipo de entidade, garantindo clareza, flexibilidade e foco na implementação da API.

Esta solução proporciona uma base sólida para o atendimento de requisitos de negócio futuros e a integração com outras soluções da AWS, se necessário.
