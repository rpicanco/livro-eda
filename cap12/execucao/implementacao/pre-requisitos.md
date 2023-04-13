<h1>Pré-requisitos</h1>

### Sistema operacional Linux 

1. Instale o MongoSH
```
$ yum install -y mongodb-mongosh
```

2. Instale o Confluent Cloud CLI
```
$ curl -sL --http1.1 https://cnfl.io/cli | sh -s -- latest
```

3. No terminal. verifique se o _Mongosh_ e o _Confluent Cloud CLI_ foram instalados corretamente.

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

* Crie sua conta gratuita seguindo o passo a passo do MongoDB Atlas em https://www.mongodb.com/cloud/atlas/register

### Uma conta gratuita no Confluent Cloud 

**Ecossistema Kafka**

* Crie sua conta gratuita seguindo o passo a passo da Confluent em https://confluent.cloud/signup
* Crie uma organização.

### Uma conta gratuita na starTree

**Apache Pinot**

* Crie sua conta gratuita seguindo o passo a passo da StarTree em https://startree.ai/saas-signup

:loudspeaker: É permitido apenas o cadastro com email corporativo;<br>
:loudspeaker: O teste gratuito (_trial_) é de 30 dias (mais que o suficiente para o nosso projeto).

### Ambiente