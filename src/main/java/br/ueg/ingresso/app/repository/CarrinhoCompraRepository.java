package br.ueg.ingresso.app.repository;

import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
    @Query("select carrinho from CarrinhoCompra carrinho " +
            "left join fetch carrinho.comprarIngresso where" +
            " carrinho.codigo = :codigo")
    Optional<CarrinhoCompra> findById(@Param("codigo") Long codigo);

}
