package br.ueg.ingresso.app.repository;

import br.ueg.ingresso.app.modelo.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

    Optional<Ingresso> findCadastroIngressoByidCodigo(Long idCodigo);

    @Query(value = "select count(i) from Ingresso i where i.idCodigo = :IdExists")
    Integer countId (Long IdExists);
}

