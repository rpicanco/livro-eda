<h1>Limpar os recursos da solução após os testes</h1>

**Objetivo**: Para evitar cobranças indesejadas, após o teste da solução no _Postman_, é recomendado a remoção/limpeza dos recursos que criamos na sua conta AWS.

## Serviço: IAM

### User

:heavy_check_mark: Remover o usuário criado para utilização no AWS CLI

:heavy_check_mark: Remover o usuário _postman_

### Policy

:heavy_check_mark: Remover a policy _LambdaEventBridgeExecutionPolicy_

:heavy_check_mark: Remover a policy _EventBridgePipeExecutionPolicy_

:heavy_check_mark: Remover a policy _Merchant-**merchantId**-invocationPolicy_

### Role

:heavy_check_mark: Remover a role _LambdaEventBridgeExecutionRole_

:heavy_check_mark: Remover a role _EventBridgePipeSourceTargetRole_

:heavy_check_mark: Remover a role _Merchant-**merchantId**-invocationRole_

## Serviço: EC2

:heavy_check_mark: Caso esteja usando o EC2 para executar os comandos do _AWS CLI_ no Linux.

## Serviço: Lambda

:heavy_check_mark: Remover a lambda _ativacao-comerciante_ 

## Serviço: API Gateway

:heavy_check_mark: Remover a API _Sistema de entrega API_

## Serviço: SQS

:heavy_check_mark: Remover a fila _pedido-entregue_

## Serviço: EventBridge

:loudspeaker: Caso tenha criado mais de um comerciante, remover seguindo o padrão de nome de acordo com o ID do comerciante (_merchant_).

:heavy_check_mark: Remover a conexão _**merchantId**-conexao_

:heavy_check_mark: Remover a API destination _**merchantId**-apidestination_

:heavy_check_mark: Remover a regra _Merchant-**merchantId**-rule_

:heavy_check_mark: Remover a pipe _EnvioNotificacao_

## Serviço: CloudWatch

:heavy_check_mark: Remover o Log groups _/aws/lambda/ativacao-comerciante_