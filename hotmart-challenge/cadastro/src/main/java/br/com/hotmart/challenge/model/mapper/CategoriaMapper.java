package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.model.dto.CategoriaDto;
import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.model.mapper.generic.BaseMapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends BaseMapper<CategoriaDto, Categoria> {

}