package br.ueg.ingresso.app.service;

import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.prog.webi.api.service.CrudService;

public interface CarrinhoCompraService extends CrudService<CarrinhoCompra, Long> {
    public ComprarIngresso getComprarIngressoById(Long id);

    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra, Long id);

    public CarrinhoCompra incluir(CarrinhoCompra modelo);

    public CarrinhoCompra obterPeloId(Long id);
}
