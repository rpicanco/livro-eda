<h2>Para usuários do Windows</h2>

Caso você esteja usando o sistema operacional _Windows_, você pode criar uma instância gratuita do EC2 da _AWS_ para executar os comandos no _Linux_. 

Para acessar o terminal do _Linux_ do EC2 via `SSH`, utilizei o cliente `SSH` _MobaXterm_.

### Sistema operacional Linux na AWS

1. Utilize uma instância gratuita do EC2 da AWS do Amazon _Linux_ 2 AMI
	* A instância tem que ser acessível publicamente; Exemplo: Public IPv4 DNS: **ec2-100-26-222-398.compute-1.amazonaws.com**
	* A instância tem que estar associada a um security group com entrada SSH no Inbound rules
		* **Type**: SSH
		* **Source**: 0.0.0.0/0
	* Crie um Key pair
	* Utilizar a configuração do **User Data** para instalar:
		* **awscliv2** (Para criar os recursos na sua conta AWS)
		
```
#!/bin/sh
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
./aws/install
```

### MobaXterm

1. Acessar o terminal do sistema operacional do _Linux_ usando um cliente `SSH`;

> Utilizei o _MobaXterm_ (https://mobaxterm.mobatek.net/), mas você pode utilizar qualquer outro de sua preferência. O procedimento é similar.

2. Em Basic SSH settings	
	* **Remote Host**: <<copia o valor do Public IPv4 DNS da instância EC2>>
	* **Specify username**: ec2-user
	* **Port**: 22
	
3. Em Advanced SSH setting
	* **Use private key**: Escolha o arquivo `.pem` criado no momento da criação da instância do EC2.