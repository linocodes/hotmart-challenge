# Hotmart Challenge

O projeto foi construido utilizando microservices e cada um deles em um docker.

## Utilização de banco de dados

Para exemplificar um projeto desacoplado utilizei dois bancos de dados um MYSQL e outro Postgres.

### Rabbitmq

Exemplicar a comunicação entre os servicos.

	- Service Venda
	- Service Avaliação

Existe um service que fica ouvindo para cosumir os dados que são enviados para fila.

	- Service Processa

### Carregamento de Notícias

O job service-noticia realiza um schedule de 2 em duas 2 horas para atualizar as noticias.
Mas também é possivel executar o job chamando o serviço via rest.

### Cadastro de CRUD

O service-cadastro é responsável por cadastrar todos os dados existentes. Entratento somente foi feito o Controller do produto.

### Buscar produtos.

No momento de entregar percebi que ele não lista todos os produtos.  Pelo motivo de nao ter gerado os dados na fila para realizar a inclusao do produto. Isso é um problema que detectei. Entretanto estava no limite da entrega.

### Ferramentas Utilzadas

	-Eh-cache
	- Flyway
	- mapStruc
	- Hystrix
	- Maven

Como rodar o projeto.

Primeiro realize o

**mvn clean install na pasta do projeto hotmart-challenge**

Com isso ele irá baixar as dependencias.

em seguinda utilize o comando

**docker-compose -f docker-compose.yml -f docker-compose.dev.yml up**



### Porta dos service
|  Service | Host  |
| ------------ | ------------ |
| Cadastro  | http://localhost:8081/crud/swagger-ui-custom.html  |
|  Venda |  http://localhost:8082/venda/swagger-ui-custom.html |
|  Avaliação  | http://localhost:8083/avaliacao/swagger-ui-custom.html  |
|  Processa |  http://localhost:8084/processa/swagger-ui-custom.html |
|  Noticia | http://localhost:8085/job/swagger-ui-custom.html   |
|  Busca |  http://localhost:8086/score/swagger-ui-custom.html |

Vou disponibilizar aos arquivos do projeto do postman.

dentro a pasta principal do projeto.

### Acesso ao banco de dados

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

### Observações

	- Não implementei a segurança dos endpoints.
	- Não fiz o test unitários en todos os serviços.

Queria ter usuado o MongoDb para ter como outro banco de dados. Porem precisaria alterar o pom.xml e fazer algumas separações. Por esse fato usei o Mysql.

O Aspect esta para qualquer requisição. Tinha pensado em inserir todos os logs do serviões no elasticSearch para ser possível visualizar o que esta ocorrendo no sistema. Mas isso não foi implementado.




