package br.unibh.sdm.backend_nobald.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_nobald.entidades.Servico;
import br.unibh.sdm.backend_nobald.persistencia.ServicoRepository;

/**
 * Classe contendo a lógica de negócio para Servico
 * @author jhcru
 *
 */
@Service
public class ServicoService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final ServicoRepository servicoRepo;

    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepo=servicoRepository;
    }
    
    public List<Servico> getServicos(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Servico> lista = this.servicoRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Servico>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

    public Servico getServicoById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Servico com o servicoId {}",id);
        }
        Optional<Servico> retorno = this.servicoRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Servico com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }
    
    public Servico getServicoByServicoId(String Id){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Optional<Servico> servico = this.servicoRepo.findById(Id);
        if (servico == null) {
        	return new Servico();
        }
        return servico.get();
    }
    
    public Servico saveServico(Servico servico){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Servico com os detalhes {}",servico.toString());
        }
        return this.servicoRepo.save(servico);
    }
    
    public void deleteServico(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Servico com id {}",id);
        }
        this.servicoRepo.deleteById(id);
    }

    public boolean isServicoExists(Servico servico){
    	Optional<Servico> retorno = this.servicoRepo.findById(servico.getId());
        return retorno.isPresent() ? true:  false;
    }

}
