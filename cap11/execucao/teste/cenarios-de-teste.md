<div class="container">
  <h1>Funcionalidade: Notificação de entrega do pedido</h1>
  <div class="panel panel-default">    
    <div class="panel-body"><p style="font-size:100px"><b>A FIM DE</b> entregar os itens dos pedidos de compra dos meus clientes<br><b>COMO UM</b> comerciante no sistema de entrega da empresa _CargaPesada_<br><b>EU QUERO</b> poder solicitar a entrega dos itens dos pedidos de compra dos meus clientes<br><b>E</b> receber uma notificação assim que meus clientes receberem os itens dos seus pedidos de compra na sua residência</p></div>
  </div>
</div>

## Cenários de teste

<details>
  <summary>Notificar a entrega do pedido para um comerciante com sucesso</summary><br>
  <b>DADO QUE</b> eu sou um comerciante registrado e ativo no sistema de entrega da empresa _CargaPesada_<br> 
  <b>E</b> eu solicito a entrega de 1 pedido do meu cliente<br>
  <b>E</b> eu informo o número do pedido<br>
  <b>E</b> eu informo os dados básicos do meu cliente, como CPF, nome e telefone<br>
  <b>E</b> eu informo o endereço de entrega válido do meu cliente<br>
  <b>QUANDO</b> eu solicito a entrega do pedido<br>
  <b>ENTÃO</b> eu devo receber uma notificação no meu endpoint HTTPS registrado informando que o pedido do meu cliente foi entregue na sua residência<br>
  <a href="/cap11/postman/" rel="some text"><img src="/cap11/imagens/icone-postman.png" alt="Postman" width="80" height="50" /></a>
</details>