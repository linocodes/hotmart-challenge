# Service Notícia (JOB)

O service notícia é um job que irá executar de duas em duas horas chamando uma api que disponibiliza esse tipo de transação.
Para evitar que as categorias seja carregadas todoas as vezes que for executar o job é realizado uma carga inicial e depois quando for executar a chamada no API nao será necessário buscar quais as categorias existentes.
No site do Api news realizei o cadastro e ele disponibilizou uma api_token que é enviado no url da requisicao.

	private static final Integer PAGE_SIZE = 100;
	private static final String URL_NEWS_API_TOP = "https://newsapi.org/v2/top-headlines?category=%s&apiKey=%s&page=1&pageSize=%s";
	private static final String APIKEY = "39ca15496a584f0191bb044d4741dd4a";

Esta url retorna o total geral de notícias para uma determinada categoria. Por um problema de restrição não é possível visualizar todas as noticas e filtrar pela data de plucação do D-1.  Existi uma restrição de uso. Conforme response abaixo.

##Exemplo:

itens pesquisados

https://newsapi.org/v2/top-headlines?category=business&apiKey=39ca15496a584f0191bb044d4741dd4a&page=1&pageSize=100

Resultado obtido

{
    "status": "ok",
    "totalResults": 2691,
    "articles": [{....}]
}

Durante a paginacao ocorre o erro:

{
    "status": "error",
    "code": "maximumResultsReached",
    "message": "You have requested too many results. Developer accounts are limited to a max of 100 results. You are trying to request results 400 to 500. Please upgrade to a paid plan if you need more results."
}

Como contorno somente a primeira pagina é exibida. e alterei o pageSize para 100.

Nesta listagem tem as últimas notícias classifadas por data de publicação entao eu considera a data corrente -1 e somente as notícas publicadas igual esta data entra no meu contador.

Uma outro recurso utilizado foi a Hystrix uma forma de exibir uma mensagem quando a API estiver fora. Conceito baseado em Circuit break.

Para esse JOB também disponibilizei um servico :

	curl -X POST "http://localhost:8085/job/api/carga-noticia/v1" -H "accept: */*"

Que tem como objetivo forçar a carga de dados mesmo que esteja fora do intervalo estipulado.

Dentro do docker-compose foi adicionado uma ferramenta de consulta de dados. Ela funciona tanto para o banco MYSQL quanto para o Postgres.

Abaixo estão os endereções para acessar os serviços.

- PostGres

	- http://localhost:9080/

		- servidor: postgres-db
		- Usuario: hotmart
    	- Senha: desafio
    	- banco de dados: challenge

- MySql

	- http://localhost:9080/

		- servidor: mysqlsrv
		- Usuario: root
    	- Senha: desafio
    	- banco de dados: challenge



O contexto do servico é /job e sta disponível na porta 8085

O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o enderço:

http://localhost:8085/job/swagger-ui-custom.html




