package br.unibh.sdm.backend_nobald.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_nobald.entidades.Barbeiro;
import br.unibh.sdm.backend_nobald.persistencia.BarbeiroRepository;

/**
 * Classe contendo a lógica de negócio para Barbeiro
 * @author jhcru
 *
 */
@Service
public class BarbeiroService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final BarbeiroRepository barbeiroRepo;

    public BarbeiroService(BarbeiroRepository barbeiroRepository){
        this.barbeiroRepo=barbeiroRepository;
    }
    
    public List<Barbeiro> getBarbeiros(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Barbeiro> lista = this.barbeiroRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Barbeiro>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

    public Barbeiro getBarbeiroByCpf(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Barbeiro com o cpf {}",id);
        }
        Optional<Barbeiro> retorno = this.barbeiroRepo.findByCpf(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Barbeiro com o cpf "+id+" nao encontrada");
        }
        return retorno.get();
    }

    public Barbeiro getBarbeiroById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Barbeiro com o id {}",id);
        }
        Optional<Barbeiro> retorno = this.barbeiroRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Barbeiro com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }
    
    public Barbeiro saveBarbeiro(Barbeiro barbeiro){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Barbeiro com os detalhes {}",barbeiro.toString());
        }
        return this.barbeiroRepo.save(barbeiro);
    }
    
    public void deleteBarbeiro(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Barbeiro com id {}",id);
        }
        this.barbeiroRepo.deleteById(id);
    }

    public boolean isBarbeiroExists(Barbeiro barbeiro){
    	Optional<Barbeiro> retorno = this.barbeiroRepo.findByCpf(barbeiro.getCpf());
        return retorno.isPresent() ? true:  false;
    }

}
