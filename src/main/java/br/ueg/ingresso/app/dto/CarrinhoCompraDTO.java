package br.ueg.ingresso.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class CarrinhoCompraDTO {

    private Long codigo;
    private BigDecimal precoFinal;

    private List<CompraIngressoDTO> compraIngressoCarrinho;
}