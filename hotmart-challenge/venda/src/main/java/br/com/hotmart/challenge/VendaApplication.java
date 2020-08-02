package br.com.hotmart.challenge;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.hotmart.challenge.model.entity.Comprador;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.model.entity.Vendedor;
import br.com.hotmart.challenge.model.queue.VendaQueue;
import br.com.hotmart.challenge.queue.VendaQueueSender;
import br.com.hotmart.challenge.service.CompradorService;
import br.com.hotmart.challenge.service.ProdutoService;
import br.com.hotmart.challenge.service.VendaService;
import br.com.hotmart.challenge.service.VendedorService;

@SpringBootApplication
public class VendaApplication implements CommandLineRunner {

	@Autowired
	private VendaService vendaService;

	@Autowired
	private VendedorService vendedorService;

	@Autowired
	private CompradorService compradorService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private VendaQueueSender sender;

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		carga();
	}

	private int randomNumber(int lowerBound, int upperBound) {
		Random r = new Random();
		return r.nextInt(upperBound - lowerBound) + lowerBound;
	}

	private String randomString(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public void carga() {

		List<Vendedor> listVendedor = vendedorService.list();
		List<Comprador> listComprador = compradorService.list();
		List<Produto> listProduto = produtoService.list();

		for (int i = 0; i < 100; i++) {

			Venda venda = new Venda();
			venda.setComprador(listComprador.get(randomNumber(1, 100)));
			venda.setProduto(listProduto.get(randomNumber(1, 100)));
			venda.setVendedor(listVendedor.get(randomNumber(1, 100)));
			venda.setPedido(randomString(10));
			venda.setQuantidade(randomNumber(1, 5));
			vendaService.insert(venda);

			VendaQueue vendaQueue = new VendaQueue();
			vendaQueue.setProduto(venda.getProduto().getId());
			vendaQueue.setQuantidade(venda.getQuantidade());
			sender.send(vendaQueue);

		}
	}

}
