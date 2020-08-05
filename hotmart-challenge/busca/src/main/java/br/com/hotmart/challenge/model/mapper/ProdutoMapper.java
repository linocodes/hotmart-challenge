package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.generic.BaseMapper;
import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper extends BaseMapper<ProdutoDto, Produto> {

}