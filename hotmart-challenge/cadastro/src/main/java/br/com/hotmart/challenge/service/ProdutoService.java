package br.com.hotmart.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseMapper;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.mapper.ProdutoMapper;
import br.com.hotmart.challenge.repository.ProdutoRepository;
import br.com.hotmart.challenge.validator.EntityOptionalValidator;

@Service
public class ProdutoService extends AbstractService<Produto, Long> implements BaseMapper<ProdutoDto, Produto> {

	@Autowired
	private ProdutoMapper mapper;

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private EntityOptionalValidator<Produto> validarEntidade;

	public ProdutoService(BaseRepository<Produto, Long> repository) {
		super(repository);
	}

	public List<ProdutoDto> getAll() {
		List<Produto> list = repository.getAll();
		validarEntidade.validadatorOptional(list);
		return mapper.toDto(list);
	}

	@Override
	public ProdutoDto toDto(Produto entity) {
		return mapper.toDto(entity);
	}

	@Override
	public Produto toEntity(ProdutoDto dto) {
		return mapper.toEntity(dto);
	}

	@Override
	public List<ProdutoDto> toDto(List<Produto> entityList) {
		return mapper.toDto(entityList);
	}

	@Override
	public List<Produto> toEntity(List<ProdutoDto> dtoList) {
		return mapper.toEntity(dtoList);
	}

	@Override
	public Produto carregaEntidade(Produto entity, Long id) {
		/**
		 * TODO Verificar com calma
		 */
		Produto produto = find(id);
		return produto;
	}

}