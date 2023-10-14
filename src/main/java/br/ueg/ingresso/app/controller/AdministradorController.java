package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.AdministradorDTO;
import br.ueg.ingresso.app.mapper.AdministradorMapper;
import br.ueg.ingresso.app.modelo.Administrador;
import br.ueg.ingresso.app.service.AdministradorService;
import br.ueg.prog.webi.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/administrar")
public class AdministradorController extends CrudController<Administrador, AdministradorDTO, Long, AdministradorMapper, AdministradorService> {
}
