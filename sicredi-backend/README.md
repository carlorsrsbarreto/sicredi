POST - http://127.0.0.1:8081/sicredi-backend/pauta
{"idPauta":null,"nmPauta":"Teste 3"}

GET - http://127.0.0.1:8081/sicredi-backend/pauta

POST - http://127.0.0.1:8081/sessao/abrir
{"idPauta":103,"qtdTempoMinutosVotacao":335}


POST - http://127.0.0.1:8081/sicredi-backend/votacao/votar
{
	"nuCpf":81244169588,
	"idPauta":103,
	"voto":"false"	
}

GET - http://127.0.0.1:8081/sicredi-backend/relatorio/votacao

GET - http://127.0.0.1:8081/sicredi-backend/relatorio/todos

POST - http://127.0.0.1:8080/sicredi-verifica-cpf/uses
{
	"nuCpf":81244169587,
	"nmUser":"Carlos Barreto",
	"stPodeVotar":"1"
}
GET - http://127.0.0.1:8080/sicredi-verifica-cpf/uses

GET - http://127.0.0.1:8080/sicredi-verifica-cpf/uses/81244169587

#Swegger
http://localhost:8081/sicredi-backend/swagger-ui.html

#Rabbit MQ:
	1. Instalar o Rabbit 
		docker run -d --hostname rabbitmq-master --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
	2. Logar no Rabbit
		http://127.0.0.1:15672/#/queues
		user guest
		pwd guest 
	3. Criar a queue com nome "report: 
#Mysql
	1. Instalar o MySql
		docker run --name sicredi-mysql -h 127.0.0.1 --protocol=tcp -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysql -d mysql:latest

#Build Backenddocker network
	1. Fazer o build do projeto
		docker build --no-cache -t sicredi/sicredi-backend .
	2. Fazer o start da aplicação
		docker run -d --name sicredi-backend -p 8081:8081 --link sicredi-verifica-cpf:sicredi-verifica-cpf --link sicredi-mysql:sicredi-mysql sicredi/sicredi-backend 

#Build Encerra Sessao
	1. Fazer o build do projeto
		docker build --no-cache -t sicredi/sicredi-encerra-sessao .
	2. Fazer o start da aplicação
		docker run -d --name sicredi-encerra-sessao -p 8082:8082 --link rabbitmq:rabbitmq --link sicredi-mysql:sicredi-mysql sicredi/sicredi-encerra-sessao 

#Build verifica cpf
	1. Fazer o build do projeto
		docker build --no-cache -t sicredi/sicredi-verifica-cpf .
	2. Fazer o start da aplicação	
		docker run -d --name sicredi-verifica-cpf -p 8080:8080 --link sicredi-mysql:sicredi-mysql sicredi/sicredi-verifica-cpf 
