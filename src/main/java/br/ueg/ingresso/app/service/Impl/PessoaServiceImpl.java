package br.ueg.ingresso.app.service.Impl;

import br.ueg.ingresso.app.modelo.Pessoa;
import br.ueg.ingresso.app.repository.PessoaRepository;
import br.ueg.ingresso.app.service.PessoaService;
import br.ueg.prog.webi.api.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl extends BaseCrudService<Pessoa, Long, PessoaRepository>
        implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    protected void prepararParaIncluir(Pessoa pessoa) {
        pessoa.setNew();
    }

    @Override
    protected void validarDados(Pessoa entidade) {
    }

    @Override
    protected void validarCamposObrigatorios(Pessoa entidade) {

    }
}