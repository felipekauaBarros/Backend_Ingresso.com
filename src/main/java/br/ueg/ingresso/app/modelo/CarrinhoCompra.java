package br.ueg.ingresso.app.modelo;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Table(name = "carrinho_compra")
public class CarrinhoCompra extends BaseEntidade<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrinho_codigo")
    private Long codigo;

    @OneToMany(mappedBy = "carrinho", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ComprarIngresso> comprarIngresso = new HashSet<>();

    @Transient
    private BigDecimal precoFinal;
}
