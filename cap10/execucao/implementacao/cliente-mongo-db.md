<h1>Visualize as coleções no MongoDB via interface gráfica</h1>

:heavy_check_mark: [Acesso ao MongoDB via interface gráfica](#acesso-mongodb-interface-grafica)

## Acesso ao MongoDB via interface gráfica

**Objetivo**: Visualizar as coleções no _MongoDB_ da solução através de uma interface gráfica. 

1. Baixe e instale uma ferramenta de interface gráfica para o _MongoDB_, como o _MongoDB Compass_

2. Com o _MongoDB Compass_ instalado, crie uma conexão com o nosso _MongoDB_ local

	* **URI**: mongodb://localhost:27017
	
	Expande a opção **Advanced Connection Options**
	
3. Na aba **Authetication**, selecione **Username/Password**
	
	* **Username**: root
	* **Password**: secret123

	Clique em _Connect_
	
:loudspeaker: Tanto a porta, para conectar no _MongoDB_ local, quanto o usuário e senha foram definidos no `docker-compose.yml`.

<img src="/cap10/imagens/acesso-mongodb-interface-grafica.png">

:loudspeaker: Na configuração inicial, teremos a coleção _inventory_ com as informações dos produtos em estoque e a coleção _state_ com as informações das cidades elegíveis para entrega dos pedidos. As outras coleções da solução (_order_, _fulfillment_, _envio_ e _payment_) serão criadas dinamicamente conforme a utilização do sistema/solução.

