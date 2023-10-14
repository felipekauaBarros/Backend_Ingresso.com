package br.ueg.ingresso.app.controller;

import br.ueg.ingresso.app.dto.CarrinhoCompraDTO;
import br.ueg.ingresso.app.mapper.CarrinhoCompraMapper;
import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.service.CarrinhoCompraService;
import br.ueg.ingresso.app.service.Impl.CarrinhoCompraServiceImpl;
import br.ueg.prog.webi.api.controller.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/${app.api.version}/carrinhocompra")
public class CarrinhoCompraController extends CrudController
<CarrinhoCompra, CarrinhoCompraDTO, Long, CarrinhoCompraMapper, CarrinhoCompraService>{



        @Autowired
        private CarrinhoCompraServiceImpl carrinhoService;


        @PostMapping("/aumentarQuantidade/{compraIngressoId}")
        public ResponseEntity<String> aumentarQuantidadeIngresso(@PathVariable Long compraIngressoId) {
            ComprarIngresso compraIngresso = carrinhoService.getComprarIngressoById(compraIngressoId);
            if (compraIngresso != null) {
                carrinhoService.aumentarQuantidadeIngresso(compraIngresso);
                return ResponseEntity.ok("Quantidade aumentada com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/diminuirQuantidade/{compraIngressoId}")
        public ResponseEntity<String> diminuirQuantidadeIngresso(@PathVariable Long compraIngressoId) {
            ComprarIngresso compraIngresso = carrinhoService.getComprarIngressoById(compraIngressoId);
            if (compraIngresso != null) {
                carrinhoService.diminuirQuantidadeIngresso(compraIngresso);
                return ResponseEntity.ok("Quantidade diminuída com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }



}
