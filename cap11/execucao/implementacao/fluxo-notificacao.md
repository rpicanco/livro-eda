<h1>Fluxo de notificação do comerciante</h1>

:heavy_check_mark: [Usuário IAM](#usuario-iam)

:heavy_check_mark: [Criar a fila SQS pedido-entregue](#criar-fila-sqs-pedido-entregue)

:heavy_check_mark: [Criar Event Bridge Pipe](#criar-event-bridge-pipe)

## Usuário IAM

**Objetivo**: Criar um usuário chamado _postman_ e gerar sua chave de acesso para conseguirmos simular um pedido entregue diretamente pelo _Postman_.

1. No terminal, crie o usuário _postman_

```
aws iam create-user \
	--user-name postman
```

2. Em seguida, crie a chave de acesso para o usuário _postman_

```
aws iam create-access-key \
	--user-name postman
```

:pencil2: Na resposta, guarde os valores dos campos `AccessKeyId` e `SecretAccessKey`, pois iremos utilizá-los como variáveis de ambiente no _Postman_ para executar os testes.

## Criar a fila SQS pedido-entregue

**Objetivo**: Criar a fila SQS _pedido-entregue_ para simularmos a notificação de um comerciante a partir de um pedido entregue. O usuário _postman_, através da sua chave de API e chave secreta, irá publicar na fila SQS _pedido-entregue_ pelo _Postman_ na execução dos testes.

1. Crie a fila SQS pedido-entregue

```
aws sqs create-queue \
	--queue-name pedido-entregue \
	--attributes file://PedidoEntreguePolicy.json
```

:loudspeaker: O arquivo _PedidoEntreguePolicy.json_ está disponível na pasta _src_ do nosso projeto do github. Esse arquivo contém a configuração da permissão para que o usuário _postman_ possa publicar o evento _pedido-entregue_.

## Criar Event Bridge Pipe

**Objetivo**: O _Event Bridge pipe_ será responsável por capturar o pedido através do evento _pedido-entregue_ do SQS e enviar para o barramento _default_ do _Event Bridge_. Com as devidas regras configuradas no barramento _default_ do _Event Bridge_ no fluxo de ativação, o comerciante irá receber a devidas notificações via `HTTPS`. 