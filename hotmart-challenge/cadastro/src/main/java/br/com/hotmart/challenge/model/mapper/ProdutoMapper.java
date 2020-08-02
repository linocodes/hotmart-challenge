package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.mapper.generic.BaseMapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper extends BaseMapper<ProdutoDto, Produto> {

}