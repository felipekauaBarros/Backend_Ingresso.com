package br.ueg.ingresso.app.mapper;

import br.ueg.ingresso.app.dto.CompraIngressoDTO;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompraIngressoMapper extends BaseMapper<ComprarIngresso, CompraIngressoDTO> {
}