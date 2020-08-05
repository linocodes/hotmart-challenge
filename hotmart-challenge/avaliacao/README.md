# Service Avaliação

O service de avaliação ocorre logo ápos a execução de uma venda. O usuário pode avaliar o produto a qualquer momento basta apenas informar o numero do pedido que foi gerado no momento da venda. Outro ponto importante é que nesse momento o usuário pode ranquear o produto com uma nota de 1 a 5. Isso irá ajudar no momento de retornar os dados na busca de produtos.

Esse ranqueamento também é processado no ambiente do MYSQL. A Avaliação do produto é repassada para uma fila no Rabbitmq e processada confirme as regras propostas.


Com base nas informações o servço irá grava o dados pertinentes da avaliacao na base de dados postgres. Em seguida os dados sâo enviados para uma fila RabbitMQ

	@Value("${rabbitmq.fila.avaliacaoProduto}")
	private String avaliacaoProdutoQueue;

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


Um outro docker que também esta disponivel é o rabbitmq que esta na url abaixo:

- http://localhost:15672


    rabbitmq:
    host: localhost
    port: 15672
    username: guest
    password: guest


O contexto do service para esse servico  é  /avaliacao e disponível na porta 8083


O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o endereço:

http://localhost:8083/avaliacao/swagger-ui-custom.html

