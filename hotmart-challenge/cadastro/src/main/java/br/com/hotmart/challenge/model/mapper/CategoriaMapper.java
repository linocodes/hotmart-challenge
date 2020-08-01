package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.model.dto.CategoriaDto;
import br.com.hotmart.challenge.model.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

	Categoria toModel(CategoriaDto dto);

	CategoriaDto toDto(Categoria model);

}