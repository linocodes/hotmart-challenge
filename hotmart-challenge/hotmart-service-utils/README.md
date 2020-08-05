# HOTMART-SERVICE-UTILS

Ele é um pacote onde disponibilizo todas as classes comuns do projeto.

Faço a configuração do swagger:

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.swagger-ui.api-docs.version}") String appVersion) {
        // @formatter:off
        return new OpenAPI()
                .info(new Info()
                .title("Challenge Hotmart")
                .version(appVersion)
                .description("Documentação do marketplace - OpenAPI 3")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                .url("http://springdoc.org")));
        // @formatter:on
    }

}

Nesse projeto também crio abstração das entidades.

Disponibilizo alguns pojos que são utilizados nos demais projetos.

Realizo o controle do aspect

	@Before("execution(public * br.com.hotmart.challenge.controller.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		log.info("==> Início Chamada Rest");
		log.info("==> Controller ( {} )", pjp.getTarget().getClass().getName());
		log.info("==> Método: ( {} )", pjp.getSignature());
	}

	@AfterReturning(value = "execution(* br.com.hotmart.challenge.controller.*Controller.*(..))", returning = "result")
	public void logAfterRestCall(JoinPoint pjp, Object result) throws Throwable {
		log.info("==> Fim Chamada Rest ({})", pjp);

	}

Ele é herdado de um pom.xml:

	<parent>
		<groupId>br.com.hotmart.challenge</groupId>
		<artifactId>hotmart-challenge</artifactId>
		<version>1.0.0-SNAPSHOT</version>
	</parent>

	<artifactId>hotmart-service-utils</artifactId>
	<version>1.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
	<name>Service Utils</name>
	<description>Pacote de utilitários</description>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
	</dependencies>


Apliquei aqui o conceito de maven e suas depências. Fiz de uma maneira bem simples só pra demonstrar no projeto marketplace.

