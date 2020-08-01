package br.com.hotmart.challenge;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.model.entity.Comprador;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.entity.Vendedor;
import br.com.hotmart.challenge.service.CategoriaService;
import br.com.hotmart.challenge.service.CompradorService;
import br.com.hotmart.challenge.service.ProdutoService;
import br.com.hotmart.challenge.service.VendedorService;

@SpringBootApplication
public class CadastroApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoria;

	@Autowired
	private VendedorService vendedor;

	@Autowired
	private CompradorService comprador;

	@Autowired
	private ProdutoService produto;

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		carga();
	}

	private String randomStringWithRepetitions(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public void carga() {

		for (int i = 0; i < 100; i++) {
			Categoria cat = new Categoria();
			cat.setNome(randomStringWithRepetitions(10));
			categoria.insert(cat);

			Vendedor ven = new Vendedor();
			ven.setNome(randomStringWithRepetitions(10));
			vendedor.insert(ven);

			Comprador comp = new Comprador();
			comp.setEmail(String.format("marcelo%s.lino@gmail.com", i));
			comp.setNome(randomStringWithRepetitions(10));
			comprador.insert(comp);

			Produto prod = new Produto();
			prod.setDescricao(String.format("descricao%s", i));
			prod.setNome(String.format("nome%s", i));
			prod.setValor(new BigDecimal(RandomStringUtils.randomNumeric(5)));
			prod.setCategoria(cat);
			produto.insert(prod);

		}
	}

}
