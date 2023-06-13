<h1>Visualize os logs dos microsserviços da solução</h1>

:heavy_check_mark: [Visualizar os logs dos microsserviços da solução](#visualizar-logs-solucao)

:heavy_check_mark: [Visualizar o log de um microsserviço/container específico](#visualizar-log-especifico)

## Visualizar os logs da solução

**Objetivo**: Visualizar os logs dos microsserviços/containers da solução para resolução de problemas. 

1. No terminal do linux, execute o comando

```
sudo make show-logs
```

2. Para buscar apenas a parte do log pelo orderId, execute o comando 

```
sudo make show-logs | grep <<orderId>>
```
Exemplo para o `orderId` **219ea075-542c-44a4-b963-1b604d78c630**

```
sudo make show-logs | grep 219ea075-542c-44a4-b963-1b604d78c630
```

<img src="/cap10/imagens/visualizar-logs-solucao.png">

## Visualizar um log específico

**Objetivo**: Visualizar o log de um microsserviço/container específico para resolução de problemas.

1. No terminal do linux, execute o comando

```
sudo docker ps
```

:point_right: Copie o `containerId` do microsserviço/container em questão.

2. Execute o comando do docker para entrar dentro do log do container

```
sudo docker container logs [containerId]
```