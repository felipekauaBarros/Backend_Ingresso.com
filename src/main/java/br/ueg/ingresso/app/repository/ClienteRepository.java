package br.ueg.ingresso.app.repository;

import br.ueg.ingresso.app.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select cliente " +
            "From Cliente cliente " +
            "inner join fetch cliente.pessoa p " +
            "where cliente.clienteCpf = :cpf")
    Optional<Cliente> findByCPF(@Param("cpf") Long cpf);
}
