<div class="container">
  <h1>Funcionalidade: Venda online</h1>
  <div class="panel panel-default">    
    <div class="panel-body"><p style="font-size:100px"><b>A FIM DE</b> receber todos os produtos do meu pedido na minha residência<br><b>COMO UM</b> cliente do <i>e-commerce</i> da empresa ABC<br><b>EU QUERO</b> poder realizar uma compra no site<br><b>E</b> receber o produto na minha residência</p></div>
  </div>
</div>

## Cenários de teste

<details>
  <summary>Realizar a compra de um produto com sucesso</summary><br>
  <b>DADO QUE</b> eu sou um cliente do <i>e-commerce</i> da empresa ABC<br>  
  <b>E</b> eu adiciono 1 produto no carrinho de compra<br>
  <b>E</b> eu sigo para o checkout<br>
  <b>E</b> eu informo um endereço de entrega elegível<br>
  <b>E</b> eu informo dados válidos de pagamento<br>
  <b>QUANDO</b> eu confirmo o pedido<br>
  <b>ENTÃO</b> eu devo receber meu pedido com 1 produto na minha residência<br>
  <a href="/cap10/postman/" rel="some text"><img src="/cap10/imagens/icone-postman.png" alt="Postman" width="80" height="50" /></a>
</details>

<details>
  <summary>Realizar a compra de um produto informando um cartão não autorizado</summary><br>
  <b>DADO QUE</b> eu sou um cliente do <i>e-commerce</i> da empresa ABC<br>  
  <b>E</b> eu adiciono 1 produto no carrinho de compra<br>
  <b>E</b> eu sigo para o checkout<br>
  <b>E</b> eu informo um endereço de entrega elegível<br>
  <b>E</b> eu informo dados válidos de pagamento de um cartão de crédito não autorizado<br>
  <b>QUANDO</b> eu confirmo o pedido<br>
  <b>ENTÃO</b> eu devo receber um e-mail informando que meu pedido foi cancelado por motivo de pagamento não autorizado<br>
</details>