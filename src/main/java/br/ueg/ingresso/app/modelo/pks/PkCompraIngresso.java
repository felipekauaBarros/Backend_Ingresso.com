package br.ueg.ingresso.app.modelo.pks;

import br.ueg.prog.webi.api.model.annotation.PkComposite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@PkComposite
public @Data class PkCompraIngresso implements Serializable {
    private Long ingressoCodigo;
    private Long carrinhoCodigo;
}
