# Service Busca

O service de busca recupera os dados do banco e exibe para o usuario. Informa também o termo que foi pesquisa.

Ele também faz o processamento do score do produto.

Para consultar as informações no base de dados:

spring:
  datasource:
    url: jdbc:h2:mem:challenge
    driverClassName: org.h2.Driver
    username: hotmart
    password: desafio
    database-platform: org.hibernate.dialect.H2Dialect
  jpa:
    open-in-view: true
    show-sql: true
    generate-ddl: true
    hibernate:
      ddl-auto: update
    database: h2
spring.h2.console.enabled: true



- H2

	- http://localhost:8086/score/h2-console

		- Usuario Login: hotmart
    	- Senha: desafio
    	- Banco: challenge



O conexto do service para esse servico  é  /score e disponível na porta 8086


O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o endereço:

http://localhost:8086/score/busca-produto/swagger-ui-custom.html

