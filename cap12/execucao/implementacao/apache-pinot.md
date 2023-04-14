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

	Clique no Botão _Add new dataset_

		* **Dataset name**: localizacoes
		* **Which data do you want to use?**: Provide my own data
	
	Clique em _Next_.
	
4. Em **Data Source**, escolha _Streaming_;

5. Escolha o _Kafka_

	* **Select connection**: New connection
	* **Connection name**: conexao-kafka-demo
	* **Broker Url**: XXXX.confluent.cloud:9092 
	* **Authentication Type**: SASL
		* **Security Protocol**: SASL_SSL
		* **SASL Mechanism**: PLAIN
		* **Username**: _api-key_
		* **Password**: _api-secret_
		
:point_right: Para pegar o _Broker Url_, vá na interface gráfica do _Confluent Cloud_ no menu à esquerda em **Cluster overview** -> **Cluster Settings** -> **Endpoints** -> **Bootstrap server**.

6. Clique em _Test connection_ para testar a conexão com o _Apache Kafka_.

<img src="/cap12/imagens/apache-pinot-teste-conexao.png">

Clique em _Next_.

7. Em **Data Modeling**

	* **Topic Name**: localizacoes_enriquecidas
	* **Data Format**: JSON
	
	Clique em _Next_.
	
8. Em **Additional Configuration**, não precisa fazer nada. Clica em _Next_

9. Pode habilitar o **Preview Data** para verificar se os valores estão de acordo com as respectivas colunas.

	Clique em _Submit_.
	
10. No **My Apps** da interface gráfica da _StarTree_, vá em **Apache Pinot Console**

11. Vá em **Query Console** e clique na tabela **localizacoes**

12. Busque informações apenas do veículo com ID 10

```
select * from localizacoes where VEICULO_ID = 10
```

Clique em _Run Query_.
	
Aparecerá a lista de localizações do veículo com ID 10.
	
TODO: imagem da querylista