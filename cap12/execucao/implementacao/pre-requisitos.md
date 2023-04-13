<h1>Pré-requisitos</h1>

<figure>
  <img src="/cap12/imagens/ambiente-execucao.png">
  <figcaption>
	<p style="text-align:center">Ambiente de execução</p>
  </figcaption>
</figure>

<img >

:heavy_check_mark: [Sistema operacional Linux](#sistema-operacional-linux)

:heavy_check_mark: [Uma conta gratuita no MongoDB Atlas](#uma-conta-gratuita-no-mongodb-atlas)

:heavy_check_mark: [Uma conta gratuita no Confluent Cloud](#uma-conta-gratuita-no-confluent-cloud)

:heavy_check_mark: [Uma conta gratuita na starTree](#uma-conta-gratuita-na-startree)

### Sistema operacional Linux 

1. Instale o _MongoSH_
```
$ yum update -y
$ touch /etc/yum.repos.d/mongodb-org-5.0.repo
$ chmod 746 /etc/yum.repos.d/mongodb-org-5.0.repo
$ echo "[mongodb-org-5.0] name=MongoDB Repository baseurl=https://repo.mongodb.org/yum/amazon/2/mongodb-org/5.0/x86_64/gpgcheck=1enabled=1 gpgkey=https://pgp.mongodb.com/server-5.0.asc" >> /etc/yum.repos.d/mongodb-org-5.0.repo
$ yum install -y mongodb-mongosh
```

2. Instale o _Confluent Cloud CLI_
```
$ curl -sL --http1.1 https://cnfl.io/cli | sh -s -- latest
```

3. No terminal, verifique se o _Mongosh_ e o _Confluent Cloud CLI_ foram instalados corretamente.

**Verifica Mongosh**
```
$ mongosh
```

**Verifica Confluent Cloud CLI**
```
$ confluent
```

>
> **Note**:
> 
> Clique <a href="para-usuarios-windows.md">aqui</a> para usuários do sistema operacional _Windows_
> 

### Uma conta gratuita no MongoDB Atlas 

**MongoDB Cloud**

* Crie sua conta gratuita seguindo o passo a passo do MongoDB Atlas em https://www.mongodb.com/cloud/atlas/register.

### Uma conta gratuita no Confluent Cloud 

**Ecossistema Kafka**

* Crie sua conta gratuita seguindo o passo a passo da Confluent em https://confluent.cloud/signup;
* Crie uma organização.

### Uma conta gratuita na starTree

**Apache Pinot**

* Crie sua conta gratuita seguindo o passo a passo da StarTree em https://startree.ai/saas-signup.

:loudspeaker: É permitido apenas o cadastro com email corporativo;<br>
:loudspeaker: O teste gratuito (_trial_) é de 30 dias (mais que o suficiente para o nosso projeto).

