package br.com.hotmart.challenge.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.SearchOperation;
import br.com.hotmart.challenge.generic.SpecSearchCriteria;
import br.com.hotmart.challenge.model.data.Notas;
import br.com.hotmart.challenge.model.data.QuantidadeVendida;
import br.com.hotmart.challenge.model.data.TermoPesquisado;
import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.response.ProdutoResponse;
import br.com.hotmart.challenge.repository.AvaliacaoProdutoRepository;
import br.com.hotmart.challenge.repository.CategoriaRepository;
import br.com.hotmart.challenge.repository.OcorrenciaVendaRepository;
import br.com.hotmart.challenge.specification.ProdutoSpecification;
import br.com.hotmart.challenge.utils.Utils;

@Service
public class BuscaProdutoServiceService {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AvaliacaoProdutoRepository avaliacaoRepository;

	@Autowired
	private OcorrenciaVendaRepository ocorrenciaVendaRepository;

	public ProdutoResponse<Produto> buscaProduto(ProdutoDto request, Pageable pagination) {

		calculoScore();

		ProdutoResponse<Produto> produto = new ProdutoResponse<>();
		TermoPesquisado termo = new TermoPesquisado();
		termo.setDateAtual(LocalDate.now());
		Map<String,String> pesquisados = new HashMap<>();

		Pageable sortedByScoreNomeCategoria = PageRequest.of(pagination.getPageNumber(),
				pagination.getPageSize(),
				Sort.by(Order.desc("score"),
						Order.asc("nome"),
						Order.asc("categoria")));


		Page<Produto> results = null;
		if (request.getId() != null) {
			ProdutoSpecification id = new ProdutoSpecification(new SpecSearchCriteria("idProduto", SearchOperation.EQUALITY, request.getId()));
			pesquisados.put("Identificador ->", request.getId().toString());
			results = produtoService.pagination(Specification.where(id), sortedByScoreNomeCategoria);
		} else {
			if (request.getCategoria() != null) {
				ProdutoSpecification categoria = new ProdutoSpecification(new SpecSearchCriteria("categoria", SearchOperation.EQUALITY, request.getCategoria()));
				pesquisados.put("Categoria ->", request.getCategoria());
				results = produtoService.pagination(Specification.where(categoria), sortedByScoreNomeCategoria);
			}
		}

		produto.setProduto(results);
		produto.setTermoPequisado(pesquisados);
		return produto;
	}

	/**
	 * Rotina para cacular o score do produto
	 */
	private void calculoScore() {

		double score = 0;
		List<Produto> lista = produtoService.list();

		List<Notas> listaNotas = mediaProduto();
		List<QuantidadeVendida> listQuantidade = quantidadeVendas();
		List<Categoria> listaCategoria = noticias();

		Map<Long, Long> mapNotas = listaNotas.stream().collect(Collectors.toMap(a -> a.getId(), a -> a.getNotas()));
		Map<Long, Long> mapVenda = listQuantidade.stream().collect(Collectors.toMap(a -> a.getId(), a -> a.getQuantidade()));
		Map<String, Integer> mapCat   = listaCategoria.stream().collect(Collectors.toMap(a -> a.getCategoria(), a -> a.getQuantidade()));

		Date today = new Date();
		for (Produto produto : lista) {

			Long notaGeral = mapNotas.get(produto.getIdProduto());
			if (notaGeral == null) {
				notaGeral = 0L;
			}
			double valorX = notaGeral / 12;

			Long vendaGeral = mapVenda.get(produto.getIdProduto());
			if (vendaGeral == null) {
				vendaGeral = 0L;
			}
			int dias = Utils.calculateDayDifference(today,produto.getDataCriacao());

			double valorY = vendaGeral / dias;

			Integer valorZ = mapCat.get(produto.getCategoria());

			score = valorX + valorY + valorZ;

			produto.setScore(score);
			produtoService.update(produto, produto.getIdProduto());

		}

	}

	/**
	 * X = Média de avaliação do produto nos últimos 12 meses
	 *
	 * @return double
	 */
	private List<Notas> mediaProduto() {
		List<Notas> notas = avaliacaoRepository.calculaNotaProduto();
		return notas;
	}

	/**
	 * Y = Quantidade de vendas/dias que o produto existe
	 *
	 * @return
	 */
	private List<QuantidadeVendida> quantidadeVendas() {
		List<QuantidadeVendida> vendidos = ocorrenciaVendaRepository.calculaVendasProduto();
		return vendidos;
	}

	/**
	 * Z = Quantidade de notícias da categoria do produto no dia corrente
	 */
	private List<Categoria> noticias() {
		 return (List<Categoria>) categoriaRepository.findAll();
	}

}