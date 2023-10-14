package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.IngressoDTO;
import br.ueg.ingresso.app.mapper.IngressoMapper;
import br.ueg.ingresso.app.modelo.Ingresso;
import br.ueg.ingresso.app.service.Impl.IngressoServiceImpl;
import br.ueg.ingresso.app.service.IngressoService;
import br.ueg.prog.webi.api.controller.CrudController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${app.api.base}/ingresso")

public class IngressoController extends CrudController
        <Ingresso, IngressoDTO,Long, IngressoMapper, IngressoService> {
    @Autowired
    private IngressoServiceImpl cadastroIngressoService;

    @PostMapping(path = "/atualizar-quantidade",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Método utilizado para atualizar a quantidade de ingressos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quantidade de ingressos atualizada",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = IngressoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Ingresso não encontrado",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            })


    public ResponseEntity<IngressoDTO> atualizarQuantidadeIngresso(@RequestParam(name = "ingressoId") Long ingressoId,
                                                                   @RequestParam(name = "novaQuantidadeIngresso") int novaQuantidadeIngresso,
                                                                   @RequestParam(name = "novaQuantidadeCompra") int novaQuantidadeCompra) {
        Ingresso ingresso = this.cadastroIngressoService.atualizarQuantidadeIngresso(ingressoId, novaQuantidadeIngresso, novaQuantidadeCompra);
        return ResponseEntity.ok(this.mapper.toDTO(ingresso));
    }




    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {

        this.ingressoService = ingressoService;
    }

    @PatchMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Método utilizado para desativar Tipo", responses = {
            @ApiResponse(responseCode = "200", description = "Ingresso desativado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IngressoDTO.class) ))
    })
    //@PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<IngressoDTO> desativar(@PathVariable(name = "id") long id){
        Ingresso tipo = this.service.desativar(id);
        return ResponseEntity.ok(this.mapper.toDTO(tipo));
    }
    @PatchMapping(path = "/{id}/ativar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Método utilizado para ativar Tipo", responses = {
            @ApiResponse(responseCode = "200", description = "Ingresso Ativado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IngressoDTO.class) ))
    })
    @PreAuthorize(value = "hasRole('SECRETARIA')")
    public ResponseEntity<IngressoDTO> ativar(@PathVariable(name = "id") long id){
        Ingresso tipo = this.service.desativar(id);
        return ResponseEntity.ok(this.mapper.toDTO(tipo));
    }


}