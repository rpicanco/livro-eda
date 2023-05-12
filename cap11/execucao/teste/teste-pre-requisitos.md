<h1>Pré-requisitos</h1>

## Objetivo 

Para conseguirmos testar a solução através da coleção do _Postman_, é necessário definir os valores das variáveis de ambiente correspondente a URL do API Gateway, URL do SQS da fila _pedido-entregue_, a região utilizada para criar a fila _pedido-entregue_, a chave de acesso (_AccessKey_), a chave secreta (_SecretKey_) do usuário _postman_ e os tokens do mock webhook.site para os dois comerciantes do teste.
  
  **URL_GATEWAY**: a URL do API Gateway<br>
  **SQS_URL**: a URL do SQS para a fila _pedido-entregue_<br>
  **REGIAO**: A região que foi utilizada para criar a fila _pedido-entregue_ no SQS<br>
  **AccessKey**: A chave de acesso do usuário _postman_<br>
  **SecretKey**: A chave secreta do usuário _postman_ 
  **WEBHOOK_SITE_TOKEN_MER1234**: O token gerado para o comerciante com ID _MER1234_ no _webhook.site_
  **WEBHOOK_SITE_TOKEN_MER5678**: O token gerado para o comerciante com ID _MER5678_ no _webhook.site_

:heavy_check_mark: [URL do API Gateway](#url-do-gateway)

:heavy_check_mark: [URL do SQS da fila pedido-entregue](#url-do-sqs-da-fila-pedido-entregue)

:heavy_check_mark: [A região utilizada para criar a fila pedido-entregue](#a-regiao-utilizada-para-criar-a-fila-pedido-entregue)

:heavy_check_mark: [A chave de acesso e a chave secreta do usuário postman)](#a-chave-de-acesso-e-chave-secreta-do-usuario-postman)

:heavy_check_mark: [O token gerado para os comerciantes no webhook.site mock)](#o-token-gerado-para-os-comerciantes-no-webhook-site-mock)

### URL do API Gateway

1. No console da AWS, entre no serviço **API Gateway**

2. No menu a esquerda, em **Stages**, entre no método **POST** dentro do stage **prd**

3. Copie a URL gerada do **Invoke URL**

> O padrão do nome é: https://{ID_GATEWAY}.execute-api.{REGIAO}.amazonaws.com/prd/ativacoes

### URL do SQS da fila pedido-entregue

1. No console da AWS, entre no serviço **SQS**

2. Na lista de filas, entre na fila _pedido-entregue_

3. Copie a URL gerada do campo **URL**

> O padrão do nome é: https://sqs.{REGIAO}.amazonaws.com/{ID_CONTA}/pedido-entregue

### A região utilizada para criar fila pedido-entregue

1. No console da AWS, entre no serviço **SQS**

2. Na lista de filas, entre na fila _pedido-entregue_

3. No campo **ARN**, copie o trecho do nome da região arn:aws:sqs:**REGIAO**:ID_CONTA:pedido-entregue

### A chave de acesso e a chave secreta do usuário postman

O mesmo par de chaves que você gerou no passo 2 do **Usuário IAM** do [fluxo de notificação do comerciante](https://github.com/rpicanco/livro-eda/blob/main/cap11/execucao/implementacao/fluxo-notificacao.md#usu%C3%A1rio-iam).

### O token gerado para os comerciantes no webhook.site mock

1. Abra o https://webhook.site/

2. Coloque o primeiro token gerado para o comerciante com ID _MER1234_

	https://webhook.site/#!/**TOKEN**
	
3. No canto superior direito, clique no botão _New_

	**Default status code**: 200

4. Coloque o segundo token gerado para o comerciante com ID _MER5678_

	https://webhook.site/#!/**TOKEN**
		
:loudspeaker:  As duas abas do _webhook.site_ devem ficar abertas no navegador. Apesar da coleção do _postman_ validar automaticamente a resposta recebida no endpoint que estamos simulando o sistema do comerciante, você poderá visualizar o `JSON` recebido no navegador.