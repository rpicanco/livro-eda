<h1>Build & Deploy da solução</h1>

:heavy_check_mark: [Clone do projeto do Github](#clone-projeto-github)

:heavy_check_mark: [Build e deploy da solução](#build-deploy-solução)

## Clone do projeto do Github

**Objetivo**: Baixar o código fonte do capítulo 10 do _Github_ para o seu ambiente local _Linux_.

1. Faça o clone do projeto

```
git clone https://github.com/rpicanco/livro-eda.git
``` 

2. Copie o código fonte do capítulo 10 (https://github.com/rpicanco/livro-eda/tree/main/cap10/src) em alguma pasta de sua preferência

## Build e deploy da solução

**Objetivo**: Contruir e deployar todos os componentes da solução no seu ambiente local _Linux_.

1. Entre na pasta onde está o código fonte baixado do _Github_

2. Realizar o build e inicialização dos componentes através do _Make_

```
sudo make build-start
```

:loudspeaker: O primeiro build e deploy é sempre mais demorado por precisar baixar todas as imagens nessecárias.

2. Verificar se a solução está rodando

:loudspeaker: Aparecerá apenas log do tipo _INFO_ e no final a lista dos componentes/containers inicializados e prontos para serem utilizados.

<img src="/cap10/imagens/build-start-sucesso.png">

:loudspeaker: Se tudo estiver ok, a solução estará pronta para ser testada no _postman_.

 