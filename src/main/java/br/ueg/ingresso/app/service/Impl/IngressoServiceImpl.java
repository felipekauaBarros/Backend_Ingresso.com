package br.ueg.ingresso.app.service.Impl;
import br.ueg.ingresso.app.exception.SistemaMessageCode;
import br.ueg.ingresso.app.modelo.ComprarIngresso;
import br.ueg.ingresso.app.modelo.Ingresso;
import br.ueg.ingresso.app.modelo.enums.StatusAtivoInativo;
import br.ueg.ingresso.app.repository.CompraIngressoRepository;
import br.ueg.ingresso.app.repository.IngressoRepository;
import br.ueg.ingresso.app.service.IngressoService;
import br.ueg.prog.webi.api.exception.BusinessException;
import br.ueg.prog.webi.api.service.BaseCrudService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class IngressoServiceImpl
        extends BaseCrudService<Ingresso, Long, IngressoRepository>
        implements IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private CompraIngressoRepository compraIngressoRepository;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    protected void prepararParaIncluir(Ingresso entidade) {
    }

    @Override
    protected void validarDados(Ingresso entidade) {
        if(entidade.getDescricaoIngresso().length() < 4) {
            throw  new BusinessException(SistemaMessageCode.MSG_CAMPO_NOME_MAIOR_QUARTO);
        }
    }

    @Override
    protected void validarCamposObrigatorios(Ingresso entidade) {
        if(Strings.isEmpty(entidade.getDescricaoIngresso())) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }
    public Ingresso desativar(Long id){
        Ingresso ingresso = this.recuperarEntidadeOuGeraErro(id);
        return ingresso;
    }

    @Override
    public boolean validarValorIngresso(Double valorIngresso) {
        return false;
    }


    public Ingresso atualizarQuantidadeIngresso(Long ingressoId, int novaQuantidadeIngresso, int novaQuantidadeCompra) {
        Ingresso ingresso = ingressoRepository.findById(ingressoId)
                .orElseThrow(() -> new EntityNotFoundException("Ingresso não encontrado com o ID: " + ingressoId));

        ingresso.setQuantidadeIngresso(novaQuantidadeIngresso);

        Optional<ComprarIngresso> optionalComprarIngresso = compraIngressoRepository.findByIngressoId(ingressoId);
        if (optionalComprarIngresso.isPresent()) {
            ComprarIngresso comprarIngresso = optionalComprarIngresso.get();

            comprarIngresso.setQuantidadeCompra(0L);
        }

        return ingressoRepository.save(ingresso);
    }



    //subscreve a classe alterar
    public Ingresso alterar(Ingresso entidade, Long id) {
        entidade.setDescricaoIngresso(entidade.getDescricaoIngresso().toLowerCase());
        return super.alterar(entidade, id);
    }

}