package br.com.hotmart.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.model.request.VendaRequest;
import br.com.hotmart.challenge.queue.VendaQueue;
import br.com.hotmart.challenge.queue.VendaQueueSender;
import br.com.hotmart.challenge.utils.Utils;

@Service
public class VendaService extends AbstractService<Venda, Long> {

	@Autowired
	private VendaQueueSender sender;

	@Autowired
	private VendedorService vendedorService;

	@Autowired
	private CompradorService compradorService;

	@Autowired
	private ProdutoService produtoService;

	public VendaService(BaseRepository<Venda, Long> repository) {
		super(repository);
	}

	public String vendaProduto(VendaRequest request) {

		validaRequisicao(request);

		Venda venda = new Venda();
		venda.setComprador(compradorService.find(request.getIdComprador()));
		venda.setProduto(produtoService.find(request.getIdProduto()));
		venda.setVendedor(vendedorService.find(request.getIdVendedor()));
		venda.setPedido(Utils.randomString(10).toUpperCase());
		venda.setQuantidade(request.getQuantidade());
		insert(venda);

		VendaQueue vendaQueue = new VendaQueue();
		vendaQueue.setIdProduto(venda.getProduto().getId());
		vendaQueue.setNome(venda.getProduto().getNome());
		vendaQueue.setDescricao(venda.getProduto().getDescricao());
		vendaQueue.setCategoria(venda.getProduto().getCategoria().getNome());
		vendaQueue.setDataCriacao(venda.getProduto().getDataCriacao());
		vendaQueue.setQuantidade(venda.getQuantidade());
		sender.send(vendaQueue);

		return venda.getPedido();

	}

	private void validaRequisicao(VendaRequest request) {

		if (request.getIdComprador() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "O código do comprador não foi infomado.");
		}

		if (request.getIdProduto() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "O código do produto não foi infomado.");
		}

		if (request.getIdVendedor() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "O código do vendador não foi infomado.");
		}

		if (request.getQuantidade() == null || request.getQuantidade() < 1) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "A quantidade informada não é válida.");
		}
	}

	@Override
	public Venda carregaEntidade(Venda entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}