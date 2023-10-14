package br.ueg.ingresso.app.modelo;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = Pessoa.NOME_TABELA)
public class Pessoa extends BaseEntidade<Long> implements Persistable<Long> {

    public static final String NOME_TABELA = "pessoa";

    @Id
    @Column(name = "cpf", updatable = false, nullable = false)
    private Long cpf;

    @Column(name = "pessoa_nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "pessoa_sobrenome", length = 20)
    private String sobrenome;


    @Column(name = "pessoa_email", length = 150)
    private String email;

    @Column(name = "pessoa_senha", nullable = false, length = 11, unique = true)
    private String senha;

    @Transient
    private boolean isNew = false;
    public void setNew(){
        this.isNew = true;
    }
    @Override
    public boolean isNew() {
        return this.isNew;
    }

}