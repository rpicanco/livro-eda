<h1>Visualizando a rota percorrida de um caminhão no mapa</h1>

## Objetivo 

<p align="justify">
  Visualizar a rota percorrida por um determinado caminhão em um mapa. Vamos também criar um efeito para simular o caminhão percorrendo a rota Rio de janeiro X São Paulo em tempo real.
</p>

## Passo a passo

1. Salve a pesquisa das coordenadas geográficas (latitude e longitude) realizada através do console do _Apache Pinot_ no formato `CSC`.

<img src="/cap12/imagens/apache-pinot-query-result-csv.png" alt="Botão CSV no resultado da pesquisa do Apache Pinot" width="700" height="400">

2. Por algum motivo, o _Apache Pinot_ adicina alguns caracteres no nome das colunas no arquivo `CSC`. Remova-os e save o arquivo.

<img src="/cap12/imagens/query-result-csv-header.png" alt="Cabeçalho do arquivo CSV gerado">

3. Abra o https://kepler.gl/ para importar o arquivo com as coordenadas geográficas.

4. Clique no botão _Get Started_

5. Em **browse your files**, importe o arquivo com as coordenadas para visualizar a rota percorrida do caminhão com número de identificação 10 no mapa.

<img src="/cap12/imagens/visualizacao-trajeto-caminhao-dez-no-mapa.png" alt="Visualização do trajeto do caminhão no mapa" width="700" height="300">

6. Para adicionar o efeito para simular o caminhão percorrendo o trajeto, vá em **Filters**.

7. Clique em _Add Filter_

8. Em **Select a field**, selecione o campo DATAHORA. Aparecerá as informações de data e hora. Cada barra e a data e hora percorrida pelo caminhão.

<img src="/cap12/imagens/efeito-para-simular-o-caminhao-percorrendo-o-trajeto.png" alt="Simulação do caminhão percorrendo o trajeto no mapa" width="600" height="200">

9. Arraste o marcador (destacado em azul na imagem anterior) para a primeira data e hora percorrida.

<img src="/cap12/imagens/primeira-data-hora-percorrida.png" alt="Primeira data e hora percorrida" width="600" height="200">

10. Clique no botão _play_

<img src="/cap12/imagens/visualizando-o-trajeto-no-mapa.gif">