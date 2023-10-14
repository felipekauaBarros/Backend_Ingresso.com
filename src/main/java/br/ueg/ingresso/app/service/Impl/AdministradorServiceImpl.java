package br.ueg.ingresso.app.service.Impl;

import br.ueg.ingresso.app.modelo.Administrador;
import br.ueg.ingresso.app.repository.AdministradorRepository;
import br.ueg.ingresso.app.service.AdministradorService;
import br.ueg.prog.webi.api.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl extends BaseCrudService<Administrador, Long, AdministradorRepository> implements AdministradorService {
    @Override
    protected void prepararParaIncluir(Administrador entidade) {

    }

    @Override
    protected void validarDados(Administrador entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Administrador entidade) {

    }
}
