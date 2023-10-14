package br.ueg.ingresso.app.mapper;

import br.ueg.ingresso.app.dto.IngressoDTO;
import br.ueg.ingresso.app.modelo.Ingresso;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngressoMapper extends BaseMapper<Ingresso, IngressoDTO> {
}