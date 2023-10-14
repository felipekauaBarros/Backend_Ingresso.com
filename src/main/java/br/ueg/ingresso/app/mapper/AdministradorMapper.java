package br.ueg.ingresso.app.mapper;

import br.ueg.ingresso.app.dto.AdministradorDTO;
import br.ueg.ingresso.app.modelo.Administrador;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministradorMapper extends BaseMapper<Administrador, AdministradorDTO> {

}