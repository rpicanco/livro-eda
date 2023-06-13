<h1>Visualize as configurações dos eventos na interface de gerenciamento do RabbitMQ</h1>

:heavy_check_mark: [Interface do gerenciamento do RabbitMQ](#interface-gerenciamento-rabbitmq)

## Interface de gerenciamento do RabbitMQ

**Objetivo**: Visualizar as configurações das _exchanges_ (eventos) da solução na interface de gerenciamento do RabbitMQ. 

1. Abra o browser e entre http://localhost:15672

	* **Username**: root
	* **Password**: secret123
	
2. No menu, clique em **Exchanges** para visualizar as exchanges/tópicos/eventos
	
:loudspeaker: Tanto a porta, para acessar a interface, quanto o usuário e senha foram definidos no `docker-compose.yml`.

<img src="/cap10/imagens/interface-gerenciamento-rabbitmq.png">