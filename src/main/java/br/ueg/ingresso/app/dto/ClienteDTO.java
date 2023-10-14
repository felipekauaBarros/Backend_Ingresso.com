package br.ueg.ingresso.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class ClienteDTO {

    public Long clienteCpf;

    public String nome;

    public String sobrenome;

    public String telefone;

    public String email;

    public String senha;

}
