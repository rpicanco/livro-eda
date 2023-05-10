<h1>Limpar os recursos da solução após os testes</h1>

**Objetivo**: Para evitar cobranças indesejadas, após o teste da solução no _Postman_, é recomendado a remoção/limpeza dos recursos que criamos na sua conta da AWS, do MongoDB Atlas, do Confluent Cloud e do Apache Pinot.

## AWS EC2

:heavy_check_mark: Terminar a instância EC2.

:loudspeaker: Caso esteja usando o EC2 para executar os comandos do _CLI_ no Linux.

## MongoDB Atlas

:heavy_check_mark: Remover a organização _TrackerJa_

:heavy_check_mark: Remover o projeto _RastreamentoFrota_

:heavy_check_mark: Remover o banco de dados _RastreamentoFrota_

:heavy_check_mark: Remover o usuário _mongo_

## Confluent Cloud

:heavy_check_mark: Remover o cluster KSQLDB _trackerJa_ksqlDB_cluster_

:heavy_check_mark: Remover o Kafka MongoDB Atlas connector _MongoDbAtlasSourceConnector_0_

:heavy_check_mark: Remover o cluster do Kafka _kafka-demo_ 

## Apache Pinot

:heavy_check_mark: Remover o dataset _localizacoes_

:heavy_check_mark: Remover a conexão _conexao-kafka-demo_

:heavy_check_mark: Remover a organização _TrackerJa_

:heavy_check_mark: Remover o workspace _RastreamentoFrota_ 