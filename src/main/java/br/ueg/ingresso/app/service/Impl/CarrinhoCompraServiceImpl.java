package br.ueg.ingresso.app.service.Impl;

import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.repository.CarrinhoCompraRepository;
import br.ueg.ingresso.app.repository.CompraIngressoRepository;
import br.ueg.ingresso.app.service.CarrinhoCompraService;
import br.ueg.prog.webi.api.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;

@Service
public class CarrinhoCompraServiceImpl
        extends BaseCrudService<CarrinhoCompra, Long, CarrinhoCompraRepository> implements CarrinhoCompraService {

    @Autowired
    private CompraIngressoRepository compraIngressoRepository;


    @Override
    protected void prepararParaIncluir(CarrinhoCompra entidade) {
    }

    @Override
    protected void validarDados(CarrinhoCompra entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(CarrinhoCompra entidade) {

    }

    public void aumentarQuantidadeIngresso(ComprarIngresso compraIngresso) {
        if (compraIngresso.getQuantidadeCompra() < compraIngresso.getQuantidadeCompra()) {
            compraIngresso.setQuantidadeCompra(compraIngresso.getQuantidadeCompra() + 1);
        }
    }

    public void diminuirQuantidadeIngresso(ComprarIngresso compraIngresso) {
        if (compraIngresso.getQuantidadeCompra() > 1) {
            compraIngresso.setQuantidadeCompra(compraIngresso.getQuantidadeCompra() - 1);
        }
    }


    public CarrinhoCompraServiceImpl(CarrinhoCompraRepository carrinhoCompraRepository) {
        super();
        this.repository = carrinhoCompraRepository;
    }

    @Override
    public ComprarIngresso getComprarIngressoById(Long id) {
        return compraIngressoRepository.findById(id).orElse(null);
    }

    private BigDecimal tratarPrecoFinal(CarrinhoCompra carrinhoCompra) {

        BigDecimal precoFinal = BigDecimal.ZERO;

        for (ComprarIngresso comprarIngresso : carrinhoCompra.getComprarIngresso()) {
            precoFinal = precoFinal.add(carrinhoCompra.getPrecoFinal());
        }

        return precoFinal;
    }

    @Override
    public CarrinhoCompra obterPeloId(Long id) {

        CarrinhoCompra retorno = (CarrinhoCompra) this.repository.findById(id).get();
        if (Objects.isNull(retorno.getComprarIngresso())) {
            retorno.setComprarIngresso(new HashSet<>());
        }
        retorno.setPrecoFinal(tratarPrecoFinal(retorno));
        return retorno;
    }

    @Override
    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra, Long id) {
        CarrinhoCompra carrinhoRetorno = super.alterar(carrinhoCompra, id);
        carrinhoRetorno.setPrecoFinal(tratarPrecoFinal(carrinhoRetorno));
        return carrinhoRetorno;
    }

    @Override
    public CarrinhoCompra incluir(CarrinhoCompra modelo) {
        CarrinhoCompra carrinhoRetorno = super.incluir(modelo);
        carrinhoRetorno.setPrecoFinal(tratarPrecoFinal(carrinhoRetorno));
        return carrinhoRetorno;
    }



}
