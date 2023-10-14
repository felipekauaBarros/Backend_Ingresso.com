package br.ueg.ingresso.app.mapper;

import br.ueg.ingresso.app.dto.ClienteDTO;
import br.ueg.ingresso.app.modelo.Cliente;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {

}

