package br.ueg.ingresso.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class CompraIngressoDTO {

    private Long compraCodigo;

    private Long carrinhoCodigo;

    private Long quantidadeCompra;

    private BigDecimal precoFinal;

    private BigDecimal precoUnitario;

    private String caminhoImagemIngresso;

    private List<IngressoDTO> IngressoCarrinho;
}