package br.ueg.ingresso.app.mapper;

import br.ueg.ingresso.app.dto.CarrinhoCompraDTO;
import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import br.ueg.prog.webi.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrinhoCompraMapper extends BaseMapper<CarrinhoCompra, CarrinhoCompraDTO> {
}