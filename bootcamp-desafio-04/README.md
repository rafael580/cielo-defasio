
# README - Mudança para UUIDs para Mitigar Vulnerabilidade IDOR

Este documento descreve a mudança que estamos fazendo em nosso sistema de
gerenciamento de IDs. Estamos adotando UUIDs (Universal Unique Identifiers) em vez
de IDs autoincrementados long. Essa mudança visa mitigar a vulnerabilidade conhecida como IDOR (Insecure Direct Object References).

## O que é o IDOR?

A vulnerabilidade IDOR (Insecure Direct Object References) ocorre quando um aplicativo web permite
que atacantes acessem objetos ou recursos diretamente, geralmente por meio de IDs previsíveis ou
incrementados sequencialmente. Isso pode levar a sérios riscos de segurança, pois os atacantes
podem acessar informações confidenciais ou executar ações não autorizadas.

## Por que estamos fazendo essa mudança?

Estamos adotando UUIDs como identificadores exclusivos em nossos sistemas para evitar a vulnerabilidade
IDOR. Os UUIDs são valores de 128 bits que são únicos em escala global e, portanto, não podem ser previstos ou adivinhados por atacantes.

Ao fazer essa mudança, estamos reforçando a segurança dos nossos sistemas, tornando mais difícil para
potenciais invasores explorarem IDs previsíveis ou sequenciais para acessar recursos ou informações não autorizados.

## Benefícios da mudança para UUIDs:

- **Maior Segurança**: Os UUIDs são difíceis de prever, tornando nossos sistemas mais seguros contra
  vulnerabilidades IDOR.

- **Privacidade e Confidencialidade**: A mudança para UUIDs ajuda a proteger informações confidenciais,
  garantindo que apenas os usuários autorizados possam acessá-las.

- **Menos Suscetibilidade a Ataques**: Ao eliminar a previsibilidade dos IDs, reduzimos a exposição
  a ataques que exploram IDs previsíveis ou sequenciais.

## Como isso afeta você:

Se você é um usuário de nossos sistemas, essa mudança não deve afetar significativamente a sua experiência.
Você ainda poderá interagir com os recursos e informações da mesma maneira, mas com um nível aprimorado de segurança.
