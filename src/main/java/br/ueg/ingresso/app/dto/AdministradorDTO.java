package br.ueg.ingresso.app.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class AdministradorDTO {

    public Long admCpf;

    public String nome;

    public String sobrenome;

    public String telefone;

    public String email;

    public String senha;

}