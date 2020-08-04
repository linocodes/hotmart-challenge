# Service Venda

O service de venda tem a função de gerenciar todas as vendas de um produto cadastrado no base de dados. Não e validado se tem disponibilidade ou nao. É apenas uma venda fictícia.
Para que ocorra o venda de um produto. O usuário deve informar os seguintes dados

- Codigo do Vendedor
- Codigo do Comprador
- Código do produto
- Quantidade comprada

Com base nas informações o servço irá grava o dados pertinentes da venda na base de dados postgres. Em seguida os dados sâo enviados para uma fila RabiitMQ

	@Value("${hotmart.challlenge.filaVenda}")
	private String vendaQueue;

Onde esses dados são recebidos e armazenados em um banco de dados MONGODB. A funcionalidade de busca de produtos e raqueamento do produto conforme as regras estabelecidas no momento da construção do service ficará sob a responsabilidade dos serviços que realizam consultas no MongoDB.

Dentro do docker-compose foi adicionado duas ferramentas de consulta de dados. Uma para o banco de dados Postgress e outro cliente para o MongoDB.

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


O conexto do service para esse servico  é  /venda e disponível na porta 8082


O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o endereço:

http://localhost:8082/venda/swagger-ui-custom.html

