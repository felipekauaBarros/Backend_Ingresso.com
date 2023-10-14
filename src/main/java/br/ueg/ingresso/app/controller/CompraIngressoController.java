package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.CompraIngressoDTO;
import br.ueg.ingresso.app.mapper.CompraIngressoMapper;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.service.ComprarIngressoService;
import br.ueg.prog.webi.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "${app.api.base}/comprar")
public class CompraIngressoController extends CrudController
        <ComprarIngresso, CompraIngressoDTO,Long, CompraIngressoMapper, ComprarIngressoService> {
}