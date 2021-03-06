# Service Processa

O service processa é responsável por receber as informações enviados pelo service venda e service avaliação. Ao receber os dados é feita a inclusão na respectivas tabelas para posterior consulta e ranqueamento do produto. Inicialmente a proposta era desenvolver esse service utilizando o mongoDB como pode ser lido em em outras assuntos da documentacao. Entretanto para que isso fosse necessário teria que dividir o pom.xml.

Pelo esse motivo adotei o banco h2 e como pode ser observado as tabelas não utilizam nenhum relacionamento. Isso é feito de proposito para deixar a select mais rápido.

Uma outro ponto interessante é observar que cada avaliação / venda  mapeadas nas tabelas abaixo:

@Data
@Builder
@Entity
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idProduto;

	private Date dataAvaliacao;

	private Integer nota;

}

@Data
@Builder
@Entity
public class OcorrenciaVenda implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idProduto;

	private Date dataVenda;

	private Integer quantidade;

}

Esta atribuido para esse serviço o controle de versão de bancos de dados. Foi utilizado o Flyway para realizar essa administração.

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>



Apenas recebo os valores e inseri nas tabelas. O motivo disso é se no futura eu quiser obter as informação de qual produto é vendido mais durante um periodo de dia. E no caso das avaliações ter uma média depois de quanto tempo o prudot é avaliado.

As seguintes filias são consumidas:


	@Value("${rabbitmq.fila.filaVenda}")
	private String vendaQueue;

	@Value("${rabbitmq.fila.avaliacaoProduto}")
	private String avaliacaoProdutoQueue;

	@Bean
	public Queue vendaQueue() {
		return new Queue(getVendaQueue(), true);
	}

	@Bean
	public Queue avaliacaoProdutoQueue() {
		return new Queue(getAvaliacaoProdutoQueue(), true);
	}

Para ficar ouvindo as dados enviados para a fila a classe abaixo esta responsável por essa finalidade:

@Service
public class ConsumerQueue {

	@Autowired
	private AvaliacaoProdutoService avaliacaoService;

	@Autowired
	private ProdutoService produtoService;

	@RabbitListener(queues = "${rabbitmq.fila.filaVenda}")
	public void receiveVenda(Message message) {
		String json = new String(message.getBody());
		produtoService.processamento(json);
	}

	@RabbitListener(queues = "${rabbitmq.fila.avaliacaoProduto}")
	public void receiveAvaliacao(Message message) {
		String json = new String(message.getBody());
		avaliacaoService.processamento(json);
	}

}

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




O contexto do servico é /processa e sta disponível na porta 8084

O projeto esta no docker.




