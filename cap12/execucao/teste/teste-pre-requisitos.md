<h1>Pré-requisitos</h1>

## Objetivo 

<p align="justify">
  Para conseguirmos testar a solução através da coleção do _Postman_, é necessário definir os valores das variáveis de ambiente no postman correspondente a URL e o token da API do Apache Pinot.  
  
  **URL_APACHE_PINOT**: a URL
  **API_KEY_APACHE_PINOT**: o token
</p> 

:heavy_check_mark: [URL do Apache Pinot](#url-do-apache-pinot)

:heavy_check_mark: [Gerar API Token para utilizar o Pinot Rest API](#gerar-api-token-para-utilizar-o-pinot-rest-api)

### URL da API do Apache Pinot

1. No _Startree_ **MyApps**, selecione a opção **Cloud Portal**

2. Clique na organização **trackerja** e em seguida workspace **rastreamentofrota**

3. Na aba **services**, copia o conteúdo da coluna **URL** da linha do cluster com o nome **pinot**.

> O padrão do nome é: proxy.broker.<<nome_do_cluster>>.<<nome_organização>>.<<nome_do_workspace>>.startree.cloud

### Gerar API Token para utilizar o Pinot Rest API

1. No _Startree_ **MyApps**, selecione a opção **Cloud Portal**

2. Clique na organização **trackerja** e em seguida workspace **rastreamentofrota**

3. Na aba **services**, clique no nome do cluster **pinot**

4. Clique na aba **Pinot API Tokens**

5. Clica no botão _Create Pinot API Token_ e save o token gerado para utilizar na variável de ambiente do _Postman_.