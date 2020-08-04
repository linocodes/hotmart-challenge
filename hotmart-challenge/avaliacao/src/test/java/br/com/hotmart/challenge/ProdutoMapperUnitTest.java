package br.com.hotmart.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.mapper.ProdutoMapper;

public class ProdutoMapperUnitTest {

    private ProdutoMapper mapper = Mappers.getMapper(ProdutoMapper.class);


	@Test
	public void compareDtoWithEntity() {
		ProdutoDto dto = new ProdutoDto();
		dto.setId(1L);
		dto.setNome("Marcelo");
		dto.setDescricao("Descricao");
		Produto entity = mapper.toEntity(dto);
		assertThat(dto.getId()).isEqualTo(entity.getId());
		assertThat(dto.getNome()).isEqualTo(entity.getNome());
	}

	@Test
	public void compareEntityWithDto() {
		Produto entity = new Produto();
		entity.setId(1L);
		entity.setNome("Marcelo");
		ProdutoDto dto = mapper.toDto(entity);
		assertThat(entity.getId()).isEqualTo(dto.getId());
		assertThat(entity.getNome()).isEqualTo(dto.getNome());
	}
}
