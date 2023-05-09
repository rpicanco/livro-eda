<h1>Fluxo de notificação do comerciante</h1>

:heavy_check_mark: [Usuário IAM](#usuario-iam)

:heavy_check_mark: [Fila SQS pedido-entregue](#fila-sqs-pedido-entregue)

:heavy_check_mark: [Event Bridge Pipe](#event-bridge-pipe)

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

:pencil2: Na resposta, guarde os valores dos campos `AccessKeyId` e `SecretAccessKey`, pois iremos utilizá-los para publicar o evento _pedido-entregue_ como variáveis de ambiente _AccessKey_ e _SecretKey_ (_Authorization_) respectivamente no _Postman_ para executar os testes.

## Fila SQS pedido-entregue

**Objetivo**: Criar a fila SQS _pedido-entregue_ para simularmos a notificação de um comerciante a partir de um pedido entregue. O usuário _postman_, através da sua chave de API e chave secreta, irá publicar na fila SQS _pedido-entregue_ pelo _Postman_ na execução dos testes.

1. Crie a fila SQS pedido-entregue

```
aws sqs create-queue \
	--queue-name pedido-entregue \
	--attributes file://PedidoEntreguePolicy.json
```

:point_right: Você precisa editar o arquivo _PedidoEntreguePolicy.json_ da pasta _src_ no github do projeto para colocar a região (a mesma configurada no _AWS CLI_) e o ID da sua conta AWS:

* **REGIAO**: us-east-1 (exemplo)
* **ID_CONTA**: [Seu ID_CONTA]

:loudspeaker: O arquivo _PedidoEntreguePolicy.json_ contém a configuração da permissão para que o usuário _postman_ possa publicar o evento _pedido-entregue_. No console, entre no serviço do _SQS_ para verificar a fila _pedido-entregue_ recém criada.

## Event Bridge Pipe

**Objetivo**: Criar o _Event Bridge pipe_ que será responsável por capturar o pedido, através do evento _pedido-entregue_, do SQS e publicar para o barramento _default_ do _Event Bridge_. Com as devidas regras (rules) configuradas no barramento _default_ do _Event Bridge_ no fluxo de ativação, o comerciante irá receber a devidas notificações via `HTTPS`. 

### Role

**Objetivo**: Criar a _role_ e as devidas políticas com as permissões para que o _Event Bridge pipe_ possa capturar eventos do _SQS_ e publicar para o barramento _default_ do _Event Bridge_.

1. Criar a política de permissão

```
aws iam create-policy \
	--policy-name EventBridgePipeExecutionPolicy \
	--policy-document file://EventBridgePipeExecutionPolicy.json
```

:point_right: Você precisa editar o arquivo _LambdaEventBridgeExecutionPolicy.json_ da pasta _src_ no github do projeto para colocar a região (a mesma configurada no _AWS CLI_) e o ID da sua conta AWS:

* **REGIAO**: us-east-1 (exemplo)
* **ID_CONTA**: [Seu ID_CONTA]

2. Crie a _role_

```
aws iam create-role \
	--role-name EventBridgePipeSourceTargetRole \
	--assume-role-policy-document '{"Version": "2012-10-17","Statement": [{ "Effect": "Allow", "Principal": {"Service": "pipes.amazonaws.com"}, "Action": "sts:AssumeRole"}]}'
```

3. Associar a politica de permissão a role recém criada

```
aws iam attach-role-policy \
	--role-name EventBridgePipeSourceTargetRole \
	--policy-arn arn:aws:iam::ID_CONTA:policy/EventBridgePipeExecutionPolicy
```

:point_right: Substitua a variável _ID_CONTA_ pelo ID da sua conta AWS.

:loudspeaker: Entre no console e pesquise pela _role_ criada no serviço do _IAM_.

## Criar o Event Bridge Pipe

1. No terminal, crie o _Event Bridge Pipe_

```
aws pipes create-pipe \
	--name EnvioNotificacao \
	--role-arn arn:aws:iam::ID_CONTA:role/EventBridgePipeSourceTargetRole \
	--source arn:aws:sqs:REGIAO:ID_CONTA:pedido-entregue \
	--target arn:aws:events:REGIAO:ID_CONTA:event-bus/default \
	--target-parameters file://PipeInputTemplate.json
```

:point_right: Substitua a variável _ID_CONTA_ pelo ID da sua conta AWS e a variável _REGIAO_ pela região configurada no _AWS CLI_.

:point_right: O arquivo _PipeInputTemplate.json_ está disponível na pasta _src_ no github do projeto.

:loudspeaker: No console, entre no serviço do _Event Bridge_. No menu a esquerda, entre em _Pipes_ para verificar o _pipe_ _EnvioNotificacao_ recém criado.

