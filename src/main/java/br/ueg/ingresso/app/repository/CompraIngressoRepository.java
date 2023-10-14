package br.ueg.ingresso.app.repository;

import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.modelo.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompraIngressoRepository extends JpaRepository<ComprarIngresso, Long> {

    Optional<ComprarIngresso> findByIngresso(Ingresso ingresso);
    Optional<ComprarIngresso>findByIngressoId(Long idCodigo);
}
