<h1>Build & Deploy da solução</h1>

:heavy_check_mark: [Clone do projeto do Github](#clone-projeto-github)

:heavy_check_mark: [Build e deploy da solução](#build-deploy-solução)

## Clone do projeto do Github

**Objetivo**: Baixar o código fonte do capítulo 10 do _Github_ para o seu ambiente local _Linux_.

1. Faça o clone do projeto em alguma pasta de sua preferência. Por exemplo, `/opt`

```
git clone https://github.com/rpicanco/livro-eda.git
``` 

2. Entre na pasta **/cap10/src/ecommerce**.

## Build e deploy da solução

**Objetivo**: Contruir e deployar todos os componentes da solução no seu ambiente local _Linux_.

1. Entre na pasta onde está o código fonte baixado do _Github_ (**/cap10/src/ecommerce**)

2. Realizar o build e inicialização dos componentes através do _Make_

```
sudo make build-start
```

:loudspeaker: O primeiro build e deploy é sempre mais demorado por precisar baixar todas as imagens nessecárias.

3. Verificar se a solução está rodando

:point_right: Aparecerá apenas log do tipo _INFO_ e no final a lista dos componentes/containers inicializados e prontos para serem utilizados.

<img src="/cap10/imagens/build-start-sucesso.png">

:point_right: Além dos microsserviços que contemplam a solução, temos o _rabbitmq_ (https://rabbitmq.com/), que é nossa solução de broker de eventos, o _Mockoon_ (https://mockoon.com/), que é a nossa solução de mock para REST API para simular o gateway de pagamento e temos o _mongo_ (https://www.mongodb.com/), que é nossa solução de banco de dados NoSQL.

:loudspeaker: Se tudo estiver ok, a solução estará pronta para ser testada no _postman_.

 