package br.ueg.ingresso.app.service.Impl;

import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.repository.CompraIngressoRepository;
import br.ueg.ingresso.app.service.ComprarIngressoService;
import br.ueg.prog.webi.api.service.BaseCrudService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CompraIngressoServiceImpl extends BaseCrudService<ComprarIngresso, Long, CompraIngressoRepository>
        implements ComprarIngressoService {
    @Override
    protected void prepararParaIncluir(ComprarIngresso entidade) {

    }

    @Override
    protected void validarDados(ComprarIngresso entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(ComprarIngresso entidade) {

    }
    public ComprarIngresso desativar(Long idCompra){
        ComprarIngresso compraringresso = this.recuperarEntidadeOuGeraErro(idCompra);
        return compraringresso;
    }


}