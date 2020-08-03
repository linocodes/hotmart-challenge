# Service Cadastro

O service de cadastro tem a função de administrar todos os CRUD do projeto.

- Crud de Vendedor
- Crud de Produto
- Crud de Comprador
- Crud de Categoria

Esta atribuido para esse serviço  o controle de versão de bancos de dados. Foi utilizado o Flyway para realizar essa administração.

Uma outra funcionalidade incoporadora no projeto é o MapStruct para não expor diretamente as entidades para o usuário.

O contexto do service é /crud. e disponivel na porta 8081.

Apesar de fazer parte do service cadastro outros entidades, elas não foram implementadas. Somente a entidade Produto tem seu controle exposto.

O service usa uma dependência

		<dependency>
			<groupId>br.com.hotmart.challenge</groupId>
			<artifactId>hotmart-service-utils</artifactId>
			<version>1.0.1-SNAPSHOT</version>
		</dependency>

que implementa todas as demais classes abstratas e controles comuns entre os projetos

O postgres é o banco utilizado nesse módulo do projeto. Os scripts para carga inicial estão na pasta src/main/resoures/db/migration.

Existe um script para carga de banco e outro para carga de dados.

server:
  port: 8081
  servlet:
    context-path: /crud
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    username: hotmart
    password: desafio
    url: jdbc:postgresql://localhost:5432/challenge
    platform: postgres
    initialization-mode: always
    continue-on-error: true
  jpa:
    open-in-view: true
    show-sql: true
    generate-ddl: true
    hibernate:
      ddl-auto: none
    database: postgresql

O projeto esta no docker.

Para visualizar o swagger da aplicação utilize o enderço:

http://localhost:8081/crud/swagger-ui-custom.html

