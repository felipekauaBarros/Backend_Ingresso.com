package br.ueg.ingresso.app.modelo.pks;

import br.ueg.prog.webi.api.model.annotation.PkComposite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@PkComposite
public @Data class PkCliente implements Serializable {

    protected Long clienteCpf;
    private Long pessoa;
}
