package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.ClienteDTO;
import br.ueg.ingresso.app.mapper.ClienteMapper;
import br.ueg.ingresso.app.modelo.Cliente;
import br.ueg.ingresso.app.service.ClienteService;
import br.ueg.prog.webi.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/cliente")
public class ClienteController extends
        CrudController<Cliente, ClienteDTO, Long, ClienteMapper, ClienteService> {

}
