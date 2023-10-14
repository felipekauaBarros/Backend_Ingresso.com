package br.ueg.ingresso.app.service;

import br.ueg.ingresso.app.modelo.Ingresso;
import br.ueg.prog.webi.api.service.CrudService;

public interface IngressoService extends CrudService<Ingresso, Long> {
    public Ingresso desativar(Long id);


    boolean validarValorIngresso(Double valorIngresso);
}
