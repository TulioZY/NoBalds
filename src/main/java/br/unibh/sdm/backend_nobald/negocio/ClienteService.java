package br.unibh.sdm.backend_nobald.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_pessoas.entidades.Cliente;
import br.unibh.sdm.backend_pessoa.persistencia.ClienteRepository;

/**
 * Classe contendo a lógica de negócio para Cliente
 * @author jhcru
 *
 */
@Service
public class ClienteService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepo=clienteRepository;
    }
    
    public List<Cliente> getClientes(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Cliente> lista = this.clienteRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Cliente>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

    public Cliente getClienteById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Cliente com o cpf {}",id);
        }
        Optional<Cliente> retorno = this.clienteRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Cliente com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }
    
    public List<Cliente> getClienteByCpf(String cpf){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Cliente> lista = this.clienteRepo.findByCpf(cpf);
        if (lista == null) {
        	return new ArrayList<Cliente>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
    
    public Cliente saveCliente(Cliente cliente){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Cliente com os detalhes {}",cliente.toString());
        }
        return this.clienteRepo.save(cliente);
    }
    
    public void deleteCliente(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Cliente com id {}",id);
        }
        this.clienteRepo.deleteById(id);
    }

    public boolean isClienteExists(Cliente cliente){
    	Optional<Cliente> retorno = this.clienteRepo.findById(cliente.getCpf());
        return retorno.isPresent() ? true:  false;
    }

}
