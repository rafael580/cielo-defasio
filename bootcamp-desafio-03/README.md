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

## Conclusão
A utilização do Amazon SQS para uma fila de atendimento compartilhada entre clientes e empresas resolve os problemas de escalabilidade, persistência de dados e alta disponibilidade. Esta solução proporciona uma base sólida para atender a requisitos de negócios futuros e integrar-se a outras soluções da AWS, quando necessário.
