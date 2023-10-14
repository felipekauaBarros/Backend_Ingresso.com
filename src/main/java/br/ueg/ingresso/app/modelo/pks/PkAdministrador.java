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
public @Data class PkAdministrador implements Serializable {

    protected Long admCpf;
    private Long pessoa;
}
