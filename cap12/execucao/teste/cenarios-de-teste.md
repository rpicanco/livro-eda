<div class="container">
  <h1>Funcionalidade: Consulta da rota percorrida da minha frota de caminhões</h1>
  <div class="panel panel-default">    
    <div class="panel-body"><p style="font-size:100px"><b>A FIM DE</b> obter a rota percorrida da minha frota de caminhões<br><b>COMO UMA</b> transportadora no sistema de rastreamento da empresa <i>TrackerJá</i><br><b>EU QUERO</b> poder consultar a rota percorrida de qualquer caminhão da minha frota</p></div>
  </div>
</div>

## Cenários de teste

<details>
  <summary>Consultar a rota percorrida de um determinado caminhão da minha frota com sucesso</summary><br>
  <b>DADO QUE</b> eu sou uma transportadora válida no sistema de rastreamento da empresa <i>TrackerJá</i><br> 
  <b>E</b> o caminhão da minha frota com número de identificação 10 saiu às 09 da manhã do dia 15 de março do Rio de janeiro<br>
  <b>E</b> o caminhão da minha frota com número de identificação 10 chegou às 10:15h da manhã do dia 15 de março em São Paulo<br>
  <b>E</b> o motorista do caminhão com número de identificação 10 é o João da Silva<br>
  <b>QUANDO</b> eu solicito a rota percorrida do meu caminhão com número de identificação 10<br>
  <b>ENTÃO</b> eu devo receber as localizações (latitude e longitude) da rota percorrida do caminhão com número de identificação 10 entre o Rio de janeiro e São Paulo<br>
  <b>E</b> o horário de saída do Rio de janeiro foi ás 09 da manhã do dia 15 de março<br>
  <b>E</b> o horário de chegada em São Paulo foi às 10:15h da manhã do dia 15 de março<br>
  <b>E</b> eu devo receber o nome do motorista João da Silva<br>
  <a href="/cap12/postman/" rel="some text"><img src="/cap12/imagens/icone-postman.png" alt="Postman" width="80" height="50" /></a>
</details>