package br.ueg.ingresso.app.modelo;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Administrador")
@Table(name = Administrador.NOME_TABELA)
public class Administrador extends BaseEntidade<Long> implements Persistable<Long> {

    public static final String NOME_TABELA = "administrador";



    @Id
    private Long admCpf;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "admCpf",
            referencedColumnName = "admCpf",
            foreignKey = @ForeignKey(name = "fk_administrador_pessoa"))
    private Pessoa pessoa;

    public Long getCpf() {
        return admCpf;
    }

    public void setCpf(Long admCpf) {
        this.admCpf = admCpf;
        if(Objects.isNull(this.getPessoa())){
            this.setPessoa(Pessoa.builder().build());
        }
        this.getPessoa().setCpf(admCpf);
    }

}
