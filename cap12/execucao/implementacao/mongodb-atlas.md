<h1>MongoDB Atlas</h1>

## Objetivo 

<p align="justify">
  Armazenar o motorista que está dirigindo o caminhão. 
</p>

## Passo a passo

1. Criar e configurar organização e projeto via interface Gráfica (https://cloud.mongodb.com/)
	* Crie uma organização com o nome **TrackerJa**;
	* Crie um projeto com o nome **RastreamentoFrota**.
	
2. Construa o cluster via Interface gráfica em **Deployment** -> **Database**

	* **Template**: M0 Free
	* **Provider**: default
	* **Region**: default
	* **Name**: RastreamentoFrota
	
	Clique em _Create_
	
	* Crie um usuário
		* **User**: mongo
		* **Password**: mongo
		
	Clique em _Create User_
	
	* **Where would you like to connect from?**: My Local Environment
	
	Clique em _Finish and close_
	
3. Permita acesso de qualquer lugar ao banco de dados via Interface gráfica em **Network Access** -> **IP Access List**

	* Edite o endereço IP cadastrado;
	* Clique em _ALLOW ACCESS FROM ANYWHERE_;
	* Clique em _Confirm_ (Aguarde o status **Active**).
	
4. Conecte ao cluster **RastreamentoFrota** via _mongosh_

	* Na Interface gráfica em **Deployment** -> **Database**, clique em _Connect_ no **RastreamentoFrota**;
	* Expande a **Shell**
	* Copie a _Connection String_
		* Substitue _myFirstDatabase_ por **trackerja-db** (será criado o banco de dados nesse momento) e adicione a opção `--password mongo`
	* Execute no terminal do seu sistema operacional:
	
	```
	$ mongosh "mongodb+srv://rastreamentofrota.<<ID>>.mongodb.net/trackerja-db" --apiVersion 1 --username mongo --password mongo
	```
	
5. Crie um índice para o campo _veiculo_id_ na coleção de _veículos_;

```
$ db.veiculos.createIndex( { "veiculo_id": 1 }, { unique: true } )
```

6. Crie a coleção de _veículos_ e insere com o nome dos motoristas

```
db.veiculos.insertOne( { veiculo_id: 10, nome_motorista: "João da Silva" } );
```

```
db.veiculos.insertOne( { veiculo_id: 20, nome_motorista: "José Duarte" } );
```

```
db.veiculos.insertOne( { veiculo_id: 30, nome_motorista: "Maria Aparecida" } );
```

7. Lista a coleção de _veículos_ para verificar se tudo está OK.

```
$ db.veiculos.find({}, {veiculo_id:1, nome_motorista:1, _id:0}) 
```

Resultado esperado:
[
  { veiculo_id: 10, nome_motorista: 'João da Silva' },
  { veiculo_id: 20, nome_motorista: 'José Duarte' },
  { veiculo_id: 30, nome_motorista: 'Maria Aparecida' }
]

:point_right: Para sair da linha de comando do mongosh: `ctrl+z`