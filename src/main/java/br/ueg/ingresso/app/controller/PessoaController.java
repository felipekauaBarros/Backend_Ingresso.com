package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.PessoaDTO;
import br.ueg.ingresso.app.mapper.PessoaMapper;
import br.ueg.ingresso.app.modelo.Pessoa;
import br.ueg.ingresso.app.service.PessoaService;
import br.ueg.prog.webi.api.controller.CrudController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/pessoa")
@PreAuthorize(value = "isAuthenticated()")
public class PessoaController extends CrudController
        <Pessoa, PessoaDTO, Long, PessoaMapper, PessoaService>
{

}