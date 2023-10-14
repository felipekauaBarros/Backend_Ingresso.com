package br.ueg.ingresso.app.modelo;

import br.ueg.ingresso.app.modelo.pks.PkCompraIngresso;
import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Getter
@Setter
@Table(name = ComprarIngresso.NOME_TABELA_COMPRA)
public class ComprarIngresso extends BaseEntidade<Long> {
    public static final String NOME_TABELA_COMPRA = "comprar-ingresso";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCodigo")
    private Long idCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrinho_codigo",
            referencedColumnName = "carrinho_codigo",
            foreignKey = @ForeignKey(name = "fk_carrinho_compra")
    )
    private CarrinhoCompra carrinho;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingresso_codigo",
            referencedColumnName = "idCodigo",
            foreignKey = @ForeignKey(name = "fk_ingresso_compra")
    )
    private Ingresso ingresso;

    @Column(name = "ingresso_quantidade", nullable = false)
    private Long quantidadeCompra;

    @Transient
    private BigDecimal precoFinal;

    @Transient
    private BigDecimal precoUnitario;

    public ComprarIngresso() {

    }

    public ComprarIngresso(Ingresso ingresso, Long quantidadeCompra) {
        this.ingresso = ingresso;
        this.quantidadeCompra = quantidadeCompra;
    }
}
