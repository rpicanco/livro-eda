<h1>Apache Pinot</h1>

## Objetivo 

Integrar o _cluster_ do _Apache Pinot_ com o tópico **localizacoes_enriquecidas** do _Apache Kafka_ para permitir consultas _OLAP_ (_Online Analytical Processing_) com baixa latência. Ele atende a mais de 50 produtos (_user-facing_) do _Linkedin_ ingerindo milhões de eventos por segundo e atendendo a mais de 100 mil consultas por segundo (_QPS_) com latência de milissegundos.

## Passo a passo

1. Na interface gráfica da _StarTree_, clique em **Create Organization**

	* **Organization name**: TrackerJa
	
	Clique em _Create_.
	
2. Crie um _workspace_ clicando no botão _Create Workspace (SAAS)_

	* **Workspace Name**: RastreamentoFrota
	* Deixa as opções default.
	
	Clique em _Create_.
	
	:loudspeaker: A criação do workspace é demorada mesmo.
	
3. Entre no **Data Manager** para configurar o **Data Source** a partir do tópico **localizacoes_enriquecidas** do _Apache Kafka_

	Clique no Botão _Create a dataset_

	* **Select Connection Type**: Kafka
	
4. Clique no botão _Create a new connection_
	
	* **Connection name**: conexao-kafka-demo
	* **Broker Url**: XXXX.confluent.cloud:9092 
	* **Authentication Type**: SASL
		* **Security Protocol**: SASL_SSL
		* **SASL Mechanism**: PLAIN
		* **Username**: _api-key_
		* **Password**: _api-secret_	

:point_right: Para pegar o _Broker Url_, vá na interface gráfica do _Confluent Cloud_ no menu à esquerda em **Cluster overview** -> **Cluster Settings** -> **Endpoints** -> **Bootstrap server**.
	
Clique em _Create connection_ e em seguida, _next_.
	
4. Em **Data Details**

	* **Dataset Description - name**: localizacoes
	* **Kafka input format - Topic name**: localizacoes_enriquecidas
	* **Kafka input format - Data format**: JSON
	
	Clique em _next_.
	
	Será exibido uma pré vissualização dos dados
	
<img src="/cap12/imagens/apache-pinot-pre-visualizacao.png">

Clique em _next_.

5. Em **Data Modeling**, vamos criar uma nova coluna de data e hora e alterar o tipo da coluna DATAHORA

	Clique em _Add New Column_
	
	* **Column name**: TIMESTAMP
	* **Field type**: DATETIME
	
	Clique em _Test transformation_ e em seguida em _Create Column_
	
	Na tabela das colunas, altere o tipo da coluna DATAHORA para DATETIME
	
	* **Column name**: DATAHORA
	* **Field type**: DATETIME	
	
	Clique em _next_.
	
6. Em **Index & additional Config**, deixa como está

	Clique em _next_.
	
7. Em **Review**, verifique as informações e clique em _Create Dataset_

8. Em **Dataset Summary**, clique em _Query console_

9. No **Query Console**, clique na tabela **localizacoes**

10. Busque informações apenas do veículo com ID 10

```
select VEICULO_ID, MOTORISTA, LATITUDE, LONGITUDE, DATAHORA from localizacoes where VEICULO_ID = 10 limit 50
```

Clique em _Run Query_.
	
Aparecerá a lista de localizações do veículo com ID 10.
	
<img src="/cap12/imagens/apache-pinot-query-result.png">

## Gerar API Token para utilizar o Pinot Rest API

1. No _Startree_ **MyApps**, selecione a opção **Cloud Portal**

2. Clique na organização **trackerja** e em seguida workspace **rastreamentofrota**

3. Na aba **services**, clique no nome do cluster **pinot**

4. Clique na aba **Pinot API Tokens**

5. Clica no botão _Create Pinot API Token_ e save o token gerado para utilizar na variável de ambiente do _Postman_.

