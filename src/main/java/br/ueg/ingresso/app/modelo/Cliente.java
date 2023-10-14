package br.ueg.ingresso.app.modelo;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@Data
@Entity
@Table(name = Cliente.NOME_TABELA)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends BaseEntidade<Long> implements Persistable<Long> {

    public static final String NOME_TABELA = "cliente";



    @Id
    private Long clienteCpf;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "clienteCpf",
            referencedColumnName = "clienteCpf",
            foreignKey = @ForeignKey(name = "fk_cliente_pessoa"))
    private Pessoa pessoa;

    public Long getCpf() {
        return clienteCpf;
    }

    public void setCpf(Long clienteCpf) {
        this.clienteCpf = clienteCpf;
        if(Objects.isNull(this.getPessoa())){
            this.setPessoa(Pessoa.builder().build());
        }
        this.getPessoa().setCpf(clienteCpf);
    }


}