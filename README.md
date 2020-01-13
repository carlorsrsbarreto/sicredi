<b><h2>Notas: </h2></b>

<br>
<b><h1>Motivação para tomadas de decisão:</h1></b>
<br>
<b>1. Divisão dos módulos:</b><br>
   1.1 A decisão foi tomada levando em consideração separar as apis de votação e criação da pauta da funcionalidade de encerrar exceção que coloquei como aplicação stand-alone<br> 
   1.2 Foi criado um módulo para simular um serviço externo. A motivação foi que o serviço estava fora poém não fiz testes unitários para esse módulo.<br>
   1.3 Eu adotaria a estratégia de computar os votos em tempo de voto ou consolidar em outra tabela em algum intervalo de tempo mas achei que aumentaria demais a complexidade do desafio.Com tabelas segmentadas a questão de performance não é um problema,considerando usar bancos SQL para NoSQL buscaria outra estratégia.	<br>
   1.4 Criar a solução como Docker favorece escalonar em uma cloud facilmente.<br>
   
Eu tinha um desejo de implementar o padrão Circuit Breaker entre os serviços de votação e validação do CPF mas não foi possível.
<br>
<b>2. Banco de Dados:</b><br>
   2.1 A escolha foi o banco MYSql mas poderia ser qualquer outro NoSql.Como dito acima sõ estratégias diferentes.<br> 	
<b>3. TInha o desejo de fazer teste de performãnce mas não foi possível - MVP 2.<br>
<b>4. Tinha o desejo de fazer teste de intefração com o Cucumber mas não foi possível - MVP 2.<br>
<b>5. Os testes unitários poderíam ser mais extenso mas  não foi possível.Optei por demonstrar o conhecimento em construir-los, não cobrir toda a aplicação - MVP 2.<br>
<b>6. Considero que poderia melhorar o detalhamento da documentação dos serviços.</b><br>
<b>7. O Docker Compose poderia ser uma opção para gerenciar os Container mas achei que agregaria mais complexidade para o desafio.</b><br>
<b>8. Técnicas como cahce de segundo nível poderia aumentar a performance mas não foi implementado - MVVP 2.</b><br>
<b>9. Tornar mais granular o serviço poderia ser uma opção, principalmente separar o serviço de votação.</b><br>
<b>10. Pamaetrizar as aplicações usando as variáveis do DockerFile - MVP - 2.</b><br>

<br>

<b><h2>Obs:Essas aplicações estão configuradas para ser usadas com o Docker. Para a instalação e utilização do programa é necessário a instalação do Docker.</h2></b>


<b><h1>Recursos utilizados para a solução:</h1></b>
 1. Spring Boot<br> 
 2. Swagger - Documentação dos serviços<br>
 3. Rabbit MQ - Messageria<br>
 4. MySQL - Banco de dados<br>
 5. Módulo sicredi-verifica-cpf - Aplicação criada para simular o serviço(GET https://user-info.herokuapp.com/users/{cpf})<br>  
 6. Módulo sicredi-encerra-sessao - Aplicação stand-alone criada para encerrar sessão<br>
 7. Logg4J - Biblioteca usada para logar na aplicação<br>
 8. SpringData - Biblioteca spring usada para manipular os dados do banco<br>
 9. JUnit - Biblioteca usada para realizar testes unitários<br>
 10. Docker - Container<br>
 
<b><h1>Docker containers :</h1></b> 

<b>Rabbit MQ:</b>
	1. Instalar o Rabbit<br> 
		docker run -d --hostname rabbitmq-master --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management<br>
	2. Logar no Rabbit<br>
		http://127.0.0.1:15672/#/queues<br>
		user guest<br>
		pwd guest<br> 
	3. Criar a queue com nome "report:<br> 

<b>Mysql</b><br>
	1. Instalar o MySql
		docker run --name sicredi-mysql -h 127.0.0.1 --protocol=tcp -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysql -d mysql:latest<br>

<b>Build Backend network</b><br>
	1. Fazer o build do projeto<br>
		docker build --no-cache -t sicredi/sicredi-backend .<br>
	2. Fazer o start da aplicação<br>
		docker run -d --name sicredi-backend -p 8081:8081 --link sicredi-verifica-cpf:sicredi-verifica-cpf --link sicredi-mysql:sicredi-mysql sicredi/sicredi-backend<br> 

<b>Build Encerra Sessao</b><br>
	1. Fazer o build do projeto<br>
		docker build --no-cache -t sicredi/sicredi-encerra-sessao .<br>
	2. Fazer o start da aplicação<br>
		docker run -d --name sicredi-encerra-sessao -p 8082:8082 --link rabbitmq:rabbitmq --link sicredi-mysql:sicredi-mysql sicredi/sicredi-encerra-sessao 

<b>Build verifica cpf</b><br>
	1. Fazer o build do projeto<br>
		docker build --no-cache -t sicredi/sicredi-verifica-cpf .<br>
	2. Fazer o start da aplicação	<br>
		docker run -d --name sicredi-verifica-cpf -p 8080:8080 --link sicredi-mysql:sicredi-mysql sicredi/sicredi-verifica-cpf<br> 

<b>Documentação Swegger - Serviços</b><br>
http://localhost:8081/sicredi-backend/swagger-ui.html<br>

<h2>Procedimento para teste :</h2> 

1. Criar uma pauta
2. Abrir a pauta
3. Votar na pauta
4. Visualisar relatorio
