package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.model.dto.VendaDto;
import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.model.mapper.generic.BaseMapper;

@Mapper(componentModel = "spring")
public interface VendaMapper extends BaseMapper<VendaDto, Venda> {

}