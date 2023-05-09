<h1>Pré-requisitos</h1>

## Objetivo 

<p align="justify">
  Para conseguirmos testar a solução através da coleção do _Postman_, é necessário definir os valores das variáveis de ambiente no _postman_ correspondente a URL do API Gateway, URL do SQS da fila _pedido-entregue_, a região utilizada para criar fila _pedido-entregue_, a chave de acesso (_AccessKey_) e a chave secreta (_SecretKey_) do usuário _postman_.  
  
  **URL_GATEWAY**: a URL do API Gateway<br>
  **SQS_URL**: a URL do SQS para a fila _pedido-entregue_<br>
  **REGIAO**: A região que foi utilizada para criar a fila _pedido-entregue_ no SQS<br>
  **AccessKey**: A chave de acesso do usuário _postman_<br>
  **SecretKey**: A chave secreta do usuário _postman_
</p> 

:heavy_check_mark: [URL do API Gateway](#url-do-gateway)

:heavy_check_mark: [URL do SQS da fila pedido-entregue](#url-do-sqs-da-fila-pedido-entregue)

:heavy_check_mark: [A região utilizada para criar fila pedido-entregue](#a-regiao-utilizada-para-criar-fila-pedido-entregue)

:heavy_check_mark: [A chave de acesso do usuário postman)](#a-chave-de-acesso-do-usuario-postman)

:heavy_check_mark: [A chave secreta do usuário postman](#a-chave-secreta-do-usuario-postman)

### URL do API Gateway

1. No console da AWS, entre no serviço **API Gateway**

2. No menu a esquerda, em **Stages**, entre no método **POST** dentro do stage **prd**

3. Copie a URL gerada do **Invoke URL**

> O padrão do nome é: XXXXXX

### URL do SQS da fila pedido-entregue

1. No console da AWS, entre no serviço **SQS**

2. Na lista de filas, entre na fila _pedido-entregue_

3. Copie a URL gerada do campo **URL**

> O padrão do nome é: XXXXXX

### A região utilizada para criar fila pedido-entregue

1. No console da AWS, entre no serviço **SQS**

2. Na lista de filas, entre na fila _pedido-entregue_

3. No campo **ARN**, copie o trecho do nome da região arn:aws:sqs:**REGIÃO**:ID_CONTA:pedido-entregue

### A chave de acesso e a chave secreta do usuário postman

O mesmo par de chaves você gerou no passo 2 do **Usuário IAM** do [fluxo de notificação do comerciante](https://github.com/rpicanco/livro-eda/blob/main/cap11/execucao/implementacao/fluxo-notificacao.md#usu%C3%A1rio-iam).