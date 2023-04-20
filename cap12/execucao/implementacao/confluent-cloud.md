<h1>Confluent Cloud</h1>

:heavy_check_mark: [Configuração do Confluent CLI](#configuracao-do-confluent-cli)

:heavy_check_mark: [Kafka Broker](#kafka-broker)

:heavy_check_mark: [Connect](#Connect)

:heavy_check_mark: [KSQLDB](#ksqldb)



## Configuração do Confluent CLI

1. No terminal, execute o comando

```
confluent login --save --no-browser
```

:pencil2: Coloque seu _email_ usado na criação da conta do _Confluent Cloud_;<br>
:pencil2: Abra a URL gerada no navegador;<br>
:pencil2: Copie o código gerado no navegador e cole no terminal.<br>

Aparecerá uma mensagem: **Logged in as <<seu email>> for organization <<id da sua organização>>**.

## Kafka Broker

**Objetivo**: Configurar um _cluster_ Kafka para criar os tópicos necessários para nossa solução. Iremos simular o envio das informações de _GPS_ dos caminhões publicando eventos diretamente no tópico de _localizacoes_.

1. Na interface gráfica do _Confluent Cloud_, crie o cluster **kafka-demo** do Kafka _Basic_ no environment _default_;

<img src="/cap12/imagens/cluster-kafka.png">

2. Entre no cluster. Vá em **Topics** do menu à esquerda e crie o tópico **localizacoes** com 1 partição
	
	* **Define a data contract**: skip

Agora, vamos simular o envio das informações do _GPS_ dos caminhões produzindo eventos no tópico **localizacoes**. Para o nosso projeto simplificado, vamos adicionar apenas algumas informações de localização. Mas imagine o sistema do _GPS_ dos caminhões publicando fluxo contínuo de eventos de localização (a cada 5 segundos, por exemplo) de cada caminhão.

3. No terminal, crie uma _API Key_ para podermos produzir os eventos simulando _GPS_ dos caminhões.

```
confluent api-key create --resource <<id do cluster>>
```

:point_right: Para copiar o ID do cluster, vá na interface gráfica do _Confluent Cloud_, em **Cluster Overview** -> **Cluster settings**.

:pencil2: Copie a _API Key_ e _API secret_ gerada, pois iremos utilizá-las mais pra frente.

4. Associe a _API Key_ gerada ao cluster

```
confluent api-key use <<api key>> --resource <<id do cluster>>
```

5. Faça o download dos três arquivos disponíveis em https://github.com/rpicanco/livro-eda/tree/main/cap12/arquivos.

	* localizacao_veiculo_10.json;
	* localizacao_veiculo_20.json;
	* localizacao_veiculo_30.json.
	
6. No terminal, gere eventos no tópico **localizacoes** simulando o envio da localização do sistema do _GPS_ do caminhão com o identificador 10.

```
confluent kafka topic produce localizacoes --parse-key --delimiter ":" --cluster <<id do cluster>> < localizacao_veiculo_10.json
```

7. No terminal, gere eventos no tópico **localizacoes** simulando o envio da localização do sistema do _GPS_ do caminhão com o identificador 20.

```
confluent kafka topic produce localizacoes --parse-key --delimiter ":" --cluster <<id do cluster>> < localizacao_veiculo_20.json
```

8. No terminal, gere eventos no tópico **localizacoes** simulando o envio da localização do sistema do _GPS_ do caminhão com o identificador 30.

```
confluent kafka topic produce localizacoes --parse-key --delimiter ":" --cluster <<id do cluster>> < localizacao_veiculo_30.json
```

9. Verifique na interface gráfica do _Confluent Cloud_ se os eventos foram publicados com sucesso no tópico **localizacoes**.

<img src="/cap12/imagens/topico-localizacoes.png">

:point_right: Caso não consiga visualizar as mensagens, busque no filtro: **Jump to offset**: digite 0 para aparecer a opção "0 / Partition: 0" para mostrar todas as mensagens geradas desde o início do log.
	
## Connect

**Objetivo**: Criar um _source conector_ do _MongoDB_ para conectar na coleção de _veículos_. O conector irá alimentar um tópico gerado automaticamente com os dados existentes na coleção no _MongoDB_. E a cada inserção do nome do motorista associado ao veículo no _MongoDB_, irá gerar um evento neste tópico em tempo real.

1. Na interface gráfica do _Confluent Cloud_, vá em **Connectors** do menu à esquerda;

2. Pesquise e clique no conector **MongoDB Atlas Source**

3. Defina o prefixo **db**

4. Escolha a opção **Use an existing API Key**
	
	* Coloque a _API key_ criada anteriormente;
	* Coloque a _API secret_ criada anteriormente.
	
5. Preencha os seguintes valores do formulário **MongoDB Atlas database details**

	* **Connection host**: rastreamentofrota.<<ID gerado>>.mongodb.net (O mesmo host utilizado para conectar no banco com o mongosh)
	* **Connection user**: mongo
	* **Connection password**: mongo
	* **Database name**: trackerja-db
	* **Collection name**: veiculos
	
	Clique em _Continue_
	
	* **Output Kafka record value format**: JSON
	
	Expande a opção **Show advanced configurations**
	
	* Altere o valor **Copy existing data** para true;
	* Em **Transforms** -> **Single Message Transform**, clique em _Add SMT_
	* Adicione 4 **Single Message Transform**<br>	
	```
	Transform type: ExtractField$Value
	Field: fullDocument
	```
	
	```
	Transform type: ReplaceField$Value
	Field (exclude): _id
	(deixe em branco os outros campos) 
	```
	
	```
	Transform type: ValueToKey
	Field: veiculo_id
	```
	
	```
	Transform type: ExtractField$Key
	Field: veiculo_id
	```
	
	Clique em _Continue_ até finalizar.
	
6. Aguarde o conector ficar com status **running**

<img src="/cap12/imagens/conector-mongo-db.png">

7. Vá em **Topics**, entre no tópico criado automaticamente pelo conector: **db.trackerja-db.veiculos** e visualize as mensagens

	* **db**: o prefixo adicionado
	* **trackerja-db**: o banco de dados em questão
	* **veiculos**: a coleção criada no MongoDB

:point_right: Caso não consiga visualizar as mensagens, busque no filtro: **Jump to offset**: digite 0 para aparecer a opção "0 / Partition: 0" para mostrar todas as mensagens geradas desde o início do log.

<img src="/cap12/imagens/topico-db-trackerja-db-veiculos.png">
	
## KSQLDB

**Objetivo**: Publicar no tópico **localizacoes_enriquecidas** a junção das informações das localizações enviadas pelo _GPS_ dos caminhões através do tópico de **localizacoes** com os nomes dos motoristas que foram recuperados da coleção de _veículos_ do banco de dados através do conector do _MongoDB_ para tópico **db.trackerja-db.veiculos**.

1. Na interface gráfica do _Confluent Cloud_, vá em **ksqlDB** do menu à esquerda;

2. Clique no botão _Create cluster myself_ para criar um _cluster ksqlDB_;

3. Escolha a opção **Global Access** e clique em _Continue_;

	* **Cluster name**: trackerJa_ksqlDB_cluster
	* **Cluster size**: 1
	* **Configuration options**: default
	
	Clique em _Launch cluster!_.

4. Aguarde o _cluster_ ficar com status **Up**

<img src="/cap12/imagens/cluster-ksqldb.png">

5. Entre no _cluster_ **trackerJa_ksqlDB_cluster**

6. Na aba **Editor**, vamos criar nosso primeiro _stream_ **localizacoes_stream** no _ksqlDB_

```
CREATE STREAM localizacoes_stream (veiculo_id VARCHAR, localizacao STRUCT<latitude DOUBLE, longitude DOUBLE>, timestamp BIGINT) 
WITH (VALUE_FORMAT = 'JSON', KAFKA_TOPIC = 'localizacoes');
```

Clique em _Run query_

:point_right: O stream **localizacoes_stream** é onde iremos armazenar todos os eventos publicados no tópico **localizacao**.

:point_right: Observe os dois campos no resultado:<br>
* **status**: SUCCESS,<br>
* **message**: Stream created
	
7. Para testar, busque as informações no stream recém criado

```
select * from LOCALIZACOES_STREAM EMIT CHANGES;
```
* **auto.offset.reset**: Earliest

:point_right: Se publicarmos um evento no tópico **localizacoes**, o stream **localizacoes_stream** será notificado em tempo real.

8. Na aba **Editor**, vamos criar nossa tabela _veiculos_ no _ksqlDB_

```
CREATE TABLE veiculos (veiculo_id VARCHAR PRIMARY KEY, nome_motorista VARCHAR) WITH (KAFKA_TOPIC = 'db.trackerja-db.veiculos', VALUE_FORMAT = 'JSON');
```

Clique em _Run query_ (se tiver executado uma query antes, clique em _Stop_ para o botão voltar a ficar visivel)

:point_right: A tabela _veiculos_ é onde iremos armazenar o nome do motorista que está dirigindo o caminhão naquele momento.

:point_right: Observe os dois campos no resultado:
* **status**: SUCCESS,
* **message**: Table created
	
9. Para testar, busque as informações na tabela recém criada

```
select * from VEICULOS EMIT CHANGES;
```
* **auto.offset.reset**: Earliest

Diferentemente do comportamento do _stream_, as informações na tabela são atualizadas, e não anexadas no final do log (_append-only_). Sempre veremos o estado atual do veículo em relação ao motorista que está dirigindo. Por exemplo, se atualizarmos o nome do motorista do veículo com ID 10 para _Roberto_ na tabela do _MongoDB_, será anexada no tópico _db.trackerja-db.veiculos_ o evento dessa atualização, entretanto, na tabela de _veículos_ do _ksqlDB_, o registro do veículo com ID 10 não será mais o _João da Silva_ e sim, o motorista _Roberto_.

Com as informações das localizações no _stream_ _localizacoes_stream_ e a associação do veículo com o nome do motorista na tabela _veiculos_, podemos criar um novo tópico chamado _localizacoes_enriquecidas_ com as informações das localizações dos caminhões enviados pelo _GPS_ com o nome do motorista que está dirigindo.

10. Na aba **Editor**, vamos criar o _stream_ _localizacoes_enriquecidas_stream_ no _ksqlDB_ e criar/associar ao tópico _localizacoes_enriquecidas_ no Kafka. Se o tópico não existir, ele será criado automaticamente no Kafka.

```
CREATE STREAM localizacoes_enriquecidas_stream WITH (kafka_topic = 'localizacoes_enriquecidas', VALUE_FORMAT = 'JSON') AS SELECT lo.veiculo_id as id, AS_VALUE(lo.veiculo_id) as veiculo_id, ve.nome_motorista as motorista, lo.localizacao->latitude as latitude, lo.localizacao->longitude as longitude, lo.timestamp as timestamp FROM localizacoes_stream lo JOIN veiculos ve ON lo.veiculo_id = ve.veiculo_id emit changes;
```

Clique em _Run query_ (se tiver executado uma query antes, clique em _Stop_ para o botão voltar a ficar visivel)

:point_right: Observe os dois campos no resultado:<br>
* **status**: SUCCESS,<br>
* **message**: Stream created
	
11. Vá em **Topics** do menu à esquerda para verificar se o tópico _localizacoes_enriquecidas_ foi criado corretamente com os devidos valores.

<img src="/cap12/imagens/topico-localizacoes-enriquecidas.png">

:point_right: Caso não consiga visualizar as mensagens, busque no filtro: **Jump to offset**: digite 0 para aparecer a opção "0 / Partition: 0" para mostrar todas as mensagens geradas desde o início do log.