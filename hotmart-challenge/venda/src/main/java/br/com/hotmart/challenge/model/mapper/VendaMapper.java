package br.com.hotmart.challenge.model.mapper;

import org.mapstruct.Mapper;

import br.com.hotmart.challenge.generic.BaseMapper;
import br.com.hotmart.challenge.model.dto.VendaDto;
import br.com.hotmart.challenge.model.entity.Venda;

@Mapper(componentModel = "spring")
public interface VendaMapper extends BaseMapper<VendaDto, Venda> {

}