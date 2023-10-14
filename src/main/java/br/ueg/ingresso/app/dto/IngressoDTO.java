package br.ueg.ingresso.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class IngressoDTO {
    private Long idCodigo;
    private String nomeEvento;
    private String loCal;
    private String descricaoIngresso;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dataIngresso;
    private Integer quantidadeIngresso;
    private BigDecimal valorIngresso;
}