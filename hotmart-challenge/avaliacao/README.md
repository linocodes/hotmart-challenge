# Service Avaliação

O service de avaliação ocorre logo ápos a execução de uma venda. O usuário pode avaliar o produto a qualquer momento basta apenas informar o numero do pedido que foi gerado no momento da venda. Outro ponto importante é que nesse momento o usuário pode ranquear o produto com uma nota de 1 a 5. Isso irá ajudar no momento de retornar os dados na busca de produtos.

Esse ranqueamento também é processado no ambiente do MongoDB. A Avaliação do produto é repassada para uma fila no Rabbitmq e processada confirme as regras propostas.


Com base nas informações o servço irá grava o dados pertinentes da avaliacao na base de dados postgres. Em seguida os dados sâo enviados para uma fila RabiitMQ

	@Value("${rabbitmq.fila.avaliacaoProduto}")
	private String avaliacaoProdutoQueue;

Os endereços de banco de dados seguem listados abaixo. Dentro do docker-compose foi adicionado duas ferramentas de consulta de dados. Uma para o banco de dados Postgress e outro cliente para o MongoDB.

Abaixo estão os endereções para acessar os serviços.

- PostGres

	- http://localhost:16543/browser/

		- Usuario Login: hotmart
    	- Senha: desafio

   - Dados do Banco

   		- Hostname: postgres-db
   		- Usuario: hotmart
   		- senha: desafio

- PostGres

	- http://localhost:3030/databaseStats

		- Ao conectar escolha o banco mongo-db


Um outro docker que também esta disponivel é o rabbitmq que esta na url abaixo:

- http://localhost:15672


    rabbitmq:
    host: localhost
    port: 15672
    username: guest
    password: guest


O conexto do service para esse servico  é  /avaliacao e disponível na porta 8083


O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o endereço:

http://localhost:8083/avaliacao/swagger-ui-custom.html

