package br.ueg.ingresso.app.service.Impl;

import br.ueg.ingresso.app.modelo.Cliente;
import br.ueg.ingresso.app.repository.ClienteRepository;
import br.ueg.ingresso.app.service.ClienteService;
import br.ueg.prog.webi.api.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseCrudService<Cliente, Long, ClienteRepository>
        implements ClienteService {

    @Override
    protected void prepararParaIncluir(Cliente entidade) {

    }

    @Override
    protected void validarDados(Cliente entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Cliente entidade) {

    }
}
