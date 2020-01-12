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