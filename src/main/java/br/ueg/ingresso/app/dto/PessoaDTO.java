package br.ueg.ingresso.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class PessoaDTO {
    private Long cpf;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

}
