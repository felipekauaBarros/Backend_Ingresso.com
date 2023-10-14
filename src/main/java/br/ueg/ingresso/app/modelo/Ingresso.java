package br.ueg.ingresso.app.modelo;


import br.ueg.ingresso.app.modelo.enums.StatusAtivoInativo;
import br.ueg.ingresso.app.modelo.enums.converter.StatusAtivoInativoConverter;
import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = Ingresso.NOME_TABELA)
public class Ingresso extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "cadastro_ingresso";

    @SequenceGenerator(
            name="ingresso_sequence",
            sequenceName = "ingresso_sequence",
            allocationSize = 1
    )

    public static final class COLUNA{
        public static final String id = "IdCodigo";
    }
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ingresso_sequence"
    )
    @Id
    @Column(name = COLUNA.id)
    private Long idCodigo;


    @Column(name = "nome_do_evento", length = 100, nullable = false)
    private String nomeEvento;

    @Column(name = "local", length = 100, nullable = false)
    private String loCal;

    @Column(name = "descricao_do_evento", length = 200, nullable = false)
    private String descricaoIngresso;

    @Column(name = "data-ingresso", length = 20)
    private LocalDate dataIngresso;


    @Column(name = "quantidade-ingresso")
    private Integer quantidadeIngresso;

    @Column(name = "valor-do-ingresso", length = 20, nullable = false)
    private BigDecimal valorIngresso;

    @Override
    public String getTabelaNome() {
        return NOME_TABELA;
    }

    @Override
    public Long getId() {
        return idCodigo;

    }

    @Override
    public void setId(Long id) {
        this.idCodigo = id;
    }
}
