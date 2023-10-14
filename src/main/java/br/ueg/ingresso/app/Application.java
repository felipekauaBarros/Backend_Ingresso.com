package br.ueg.ingresso.app;

import br.ueg.ingresso.app.modelo.CarrinhoCompra;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.modelo.Ingresso;
import br.ueg.ingresso.app.repository.CarrinhoCompraRepository;
import br.ueg.ingresso.app.repository.CompraIngressoRepository;
import br.ueg.ingresso.app.repository.IngressoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication(
        scanBasePackages = {
                "br.ueg.ingresso.app.*",
                // Para funcionamento da Arquitetura
                "br.ueg.prog.webi.*"
        }
)
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {
                "br.ueg.ingresso.app.*",
                // Para funcionamento da Arquitetura
                "br.ueg.prog.webi.api.*"
        }
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IngressoRepository ingressoRepository, CompraIngressoRepository compraIngressoRepository, CarrinhoCompraRepository carrinhoCompraRepository) {
        return args -> {
            System.out.println("Executado");

            System.out.println(ingressoRepository);
            Ingresso ingresso1 = new Ingresso();
            ingresso1.setIdCodigo(1L);
            ingresso1.setNomeEvento("Arraiana 2023");
            ingresso1.setLoCal("Avenida Brasil - Estadio Jonas Duarte");
            ingresso1.setDescricaoIngresso("Show Maiara e Maraisa");
            LocalDate lanca = LocalDate.of(2023, 07, 25);
            ingresso1.setDataIngresso(lanca);
            ingresso1.setValorIngresso(new BigDecimal("20"));
            ingresso1.setQuantidadeIngresso(2);
            ingressoRepository.save(ingresso1);

            Ingresso ingresso3 = new Ingresso();
            ingresso3.setIdCodigo(1L);
            ingresso3.setNomeEvento("Arraiana 2023");
            ingresso3.setLoCal("Avenida Brasil - Estadio Jonas Duarte");
            ingresso3.setDescricaoIngresso("Show Jorge e Matheus");
            LocalDate lanca2 = LocalDate.of(2023, 06, 25);
            ingresso3.setDataIngresso(lanca2);
            ingresso3.setValorIngresso(new BigDecimal("20"));
            ingresso3.setQuantidadeIngresso(4);
            ingressoRepository.save(ingresso3);


            Optional<Ingresso> ingressoOptional = ingressoRepository.findById(1L);
            if (ingressoOptional.isPresent()) {
                Ingresso ingresso2 = ingressoOptional.get();
                System.out.println("Ingresso: " + ingresso2.getNomeEvento());

                CarrinhoCompra carrinho = new CarrinhoCompra();
                carrinho.setPrecoFinal(new BigDecimal("0.00"));
                carrinho.getComprarIngresso().add(new ComprarIngresso(ingresso2, 0L));
                carrinho = carrinhoCompraRepository.save(carrinho);

                 CarrinhoCompra carrinhoEncontrado = carrinhoCompraRepository.findById(carrinho.getId()).orElse(null);
                if (carrinhoEncontrado != null) {
                    System.out.println("Carrinho de Compra Encontrado. ID: " + carrinhoEncontrado.getId());
                    for (ComprarIngresso compra : carrinhoEncontrado.getComprarIngresso()) {
                        System.out.println("Ingresso associado ao Carrinho: " + compra.getIngresso().getNomeEvento());
                    }
                } else {
                    System.out.println("Carrinho de Compra não encontrado.");
                }

                ComprarIngresso compraIngresso = compraIngressoRepository.findByIngresso(ingresso2).orElse(null);
                if (compraIngresso != null) {
                    System.out.println("Compra de Ingresso relacionada ao Ingresso: " + compraIngresso.getIngresso().getNomeEvento());
                    System.out.println("Quantidade de Compra: " + compraIngresso.getQuantidadeCompra());
                } else {
                    System.out.println("Nenhuma compra de ingresso encontrada para o ingresso: " + ingresso2.getNomeEvento());
                }
            } else {
                System.out.println("Ingresso não encontrado.");
            }

            imprimirListaIngressos(ingressoRepository);
        };
    }

    private void imprimirListaIngressos(IngressoRepository ingressoRepository) {
        Iterable<Ingresso> ingressos = ingressoRepository.findAll();
        ingressos.forEach(ingresso -> {
            System.out.println("Ingresso: " + ingresso.getNomeEvento());
        });
    }
}
