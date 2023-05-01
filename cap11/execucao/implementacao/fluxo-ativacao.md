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

## API Gateway


