package br.ueg.ingresso.app.repository;

import br.ueg.ingresso.app.modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Query("select adm " +
            "From Administrador adm " +
            "inner join fetch adm.pessoa p " +
            "where adm.admCpf = :cpf")
    Optional<Administrador> findByCPF(@Param("cpf") Long cpf);
}
