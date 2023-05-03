<h1>Fluxo de ativação do comerciante</h1>

:heavy_check_mark: [Usuário IAM](#usuario-iam)

:heavy_check_mark: [Configuração do AWS CLI](#configuracao-do-aws-cli)

:heavy_check_mark: [Lambda](#lambda)

:heavy_check_mark: [API Gateway](#api-gateway)

## Usuário IAM

**Objetivo**: Criar um usuário no _IAM_ com perfil de administrador para criar a chave de acesso _Access key_ e _Secret access key_ para configurar o _AWS CLI_.

:point_right: Para criar o usuário IAM que será utilizado no projeto, você precisa logar com seu usuário _root_.

:point_right: Como boa prática, você deve criar um usuário IAM para logar no console e _CLI_ ao invés de usar o seu usuário _root_.

1. No console da AWS (https://console.aws.amazon.com), entre no serviço do _IAM_

2. No menu a esquerda, entre em **Users**

3. Clique no botão _Add users_

4. Digite o nome do usuário de sua preferência

	Clique em _Next_

5. Selecione a opção **Attach policies directly**

6. Na barra de pesquisa da política de permissões, pesquise por _AdministratorAccess_

7. Selecione a política de permissão _AdministratorAccess_

	Clique em _Next_ e em seguida _Create User_
	
8. Na lista de usuários, entre no usuário recém criado

9 - Entre na aba **Security Credentials**

10 - Em **Console sign-in**, clique no botão _Enable console access_ e siga os passos para você conseguir logar com esse usuário IAM pelo console.

11 - Em **Access keys**, clique no botão _Create access key_

12. Selecione a opção **Command Line Interface (CLI)**

13. Aceite o termo, clique em _Next_ e em seguida, clique em _Create access key_

14. Anote o _Access key_ e _Secret access key_, pois utilizaremos para configurar o _AWS CLI_.

:loudspeaker: Baixe o arquivo `CSV` com o _Access key_ e _Secret access key_. Quando sair da tela de criação, a chave não ficará disponível para visualização.

## Configuração do AWS CLI

**Objetivo**: Configurar o _AWS CLI_ para criarmos os serviços/componentes do fluxo de ativação e notificação do comerciante de acordo com o diagrama da arquitetura da solução.

1. No terminal, configure o _AWS CLI_

```
aws configure
```

* **AWS Access Key ID [None]**: <<_Access key_>>
* **AWS Secret Access Key [None]**: <<_Secret access key_>>
* **Default region name [None]**: us-east-1
* **Default output format [None]**: json

:loudspeaker: Você pode alterar a região de sua preferência. Quando for conferir os serviços/componentes (específicos de região) criados pelo _AWS CLI_ no console, certifique-se que a região selecionada no console é a mesma configurada no _AWS CLI_. 

## Lambda

**Objetivo**: Criar a função lambda _javascript_ utilizando o _SDK_ da AWS para criar os componentes/serviços necessários para ativar a comerciante no sistema de entrega.

### Role

**Objetivo**: Criar a _role_ que dará as devidas permissões para a função lambda criar os componentes/serviços.

1. Criar a política de permissão

```
aws iam create-policy \
	--policy-name LambdaEventBridgeExecutionPolicy \
	--policy-document file://LambdaEventBridgeExecutionPolicy.json
```

:point_right: Você precisa editar o arquivo _LambdaEventBridgeExecutionPolicy.json_ da pasta _src_ no github do projeto para colocar a região e o ID da sua conta AWS:

* **REGIAO**: us-east-1
* **ID_CONTA**: [Seu ID_CONTA]

:loudspeaker: Para saber o ID da sua conta, entre no console. No canto superior a direita, expande o seu usuário. Copia o _Account ID_.

2. Criar a _role_

```
aws iam create-role \
	--role-name LambdaEventBridgeExecutionRole \
	--assume-role-policy-document '{"Version": "2012-10-17","Statement": [{ "Effect": "Allow", "Principal": {"Service": "lambda.amazonaws.com"}, "Action": "sts:AssumeRole"}]}'
```

3. Associar a politica de permissão a _role_ recém criada

```
aws iam attach-role-policy \
	--role-name LambdaEventBridgeExecutionRole \ 
	--policy-arn arn:aws:iam::{ID_CONTA}:policy/LambdaEventBridgeExecutionPolicy
```

:point_right: Substitua a variável _ID_CONTA_ pelo ID da sua conta AWS.

:loudspeaker: Entre no console e pesquise pela _role_ criada no serviço do _IAM_.

### Função lambda registro-webhook

1. Criar a função lambda registro-webhook

```
aws lambda create-function \
    --function-name registro-webhook \
    --runtime nodejs18.x \
    --zip-file fileb://registro-webhook.zip \
    --handler index.handler \
    --role arn:aws:iam::ID_CONTA:role/LambdaEventBridgeExecutionRole	
```
	
:point_right: Substitua a variável _ID_CONTA_ pelo ID da sua conta AWS.

:loudspeaker: O arquivo _registro-webhook.zip_ está disponível no nosso projeto do github com os arquivos _javascript_ necessários. 

2. Adiciona a variável de ambiente referente ao ID da conta na função lambda

```
aws lambda update-function-configuration \
	--function-name registro-webhook \
	--environment "Variables={AWS_ACCOUNT_NUMBER=ID_CONTA}"
```

:point_right: Substitua a variável _ID_CONTA_ pelo ID da sua conta AWS.

:loudspeaker: Entre no console e entre na função _registro-webhook_ no serviço _Lambda_.

## API Gateway

**Objetivo**: Criar a API do sistema de entrega de acordo com o contrato OpenAPI. A URL gerada pelo gateway será utilizado no _postman_ para ativação do comerciante. 

1. Criar a API importando o OpenAPI do sistema de entrega disponivel no nosso projeto do Github

```
aws apigateway import-rest-api \
	--parameters endpointConfigurationTypes=REGIONAL \
	--body "fileb://sistema-entrega.yml"
```

2. No console, entre no serviço _API Gateway_

3. Na lista de APIs, entre na API _Sistema de entrega API_ recém criada

4. No menu a esquerda, em **resources**, clique no método `POST` do recurso _/registros_

5. Na tela **/registros - POST - Setup**, em **Choose the integration point for your new method**, vamos configurar a integração entre a rota (route) **POST /registros** com a função lambda _registro-webhook_

	* **Integration type**: Lambda Function
	* **Lambda Region**: Deixe a mesma região configurada no _AWS CLI_
	* **Lambda Function**: Adicione o nome da função _registro-webhook_
	
	Clique em _Save_
	
6. Na janela de Pop-up **Add Permission to Lambda Function**, clique no botão _OK_ para confirmar a adição da permissão da execução da função lambda pelo API Gateway.

7. Ainda em **Resources**, Clique em **Action** e em seguida _Deploy API_

	* **Deployment stage**: [New Stage]
	* **Stage name**: prd
	
	Clique em _Deploy_
	
8. No menu a esquerda, em **Stages**, entre no método `POST` dentro do _stage_ **prd** recém criado.

9. Copie a URL gerada do **Invoke URL**.
	
:point_right: Copie a URL gerada pelo API Gateway e utilize-a na variável de ambiente _URL_GATEWAY_ do _postman_, disponível no nosso projeto do Github, para testar o fluxo de ativação. Exemplo de URL:  https://{ID_API_REST}.execute-api.{REGIAO}.amazonaws.com/prd/{RECURSO}

:loudspeaker: O valor do {RECURSO} é o mesmo definido no OpenAPI: **registros**