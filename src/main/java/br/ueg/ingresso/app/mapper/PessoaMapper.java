package br.ueg.ingresso.app.mapper;


import br.ueg.ingresso.app.dto.PessoaDTO;
import br.ueg.ingresso.app.modelo.Pessoa;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper extends BaseMapper<Pessoa, PessoaDTO> {
}