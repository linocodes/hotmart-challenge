# Service Busca

O service de busca recupera os dados do banco e exibe para o usuario. Informa também o termo que foi pesquisa.

Ele também faz o processamento do score do produto.

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

O conexto do service para esse servico  é  /score e disponível na porta 8086

O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o endereço:

http://localhost:8086/score/busca-produto/swagger-ui-custom.html

