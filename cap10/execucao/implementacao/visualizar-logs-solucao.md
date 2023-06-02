<h1>Visualize os logs dos microsserviços da solução</h1>

:heavy_check_mark: [Visualizar os logs dos microsserviços da solução](#visualizar-logs-solucao)

:heavy_check_mark: [Visualizar o log de um microserviço/container específico](#visualizar-log-especifico)

## Visualizar os logs da solução

**Objetivo**: Visualizar os logs dos microserviços/containers da solução para resolução de problemas. 

1. No terminal do linux, execute o comando

```
sudo make show-logs
```

<img src="/cap10/imagens/visualizar-logs-solucao.png">


## Visualizar um log específico

**Objetivo**: Visualizar o log de um microserviço/container específico para resolução de problemas.

1. No terminal do linux, execute o comando

```
sudo docker ps
```

<img src="/cap10/imagens/docker-ps.png">

:point_right: Copie o `containerId` do microserviço/container em questão.

2. Execute o comando do docker para entrar dentro do log do container

```
sudo docker container logs [containerId]
```