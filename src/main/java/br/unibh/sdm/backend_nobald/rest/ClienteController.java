package br.unibh.sdm.backend_nobald.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_nobald.entidades.Cliente;
import br.unibh.sdm.backend_nobald.negocio.ClienteService;

/**
 * Classe contendo as definições de serviços REST/JSON para Cliente
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "cliente")
public class ClienteController {
   
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }

    @GetMapping(value = "")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    
    @GetMapping(value="{id}")
    public Cliente getClienteById(@PathVariable String id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return clienteService.getClienteById(id);
        }
        throw new Exception("Cliente com codigo "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody @NotNull Cliente cliente) throws Exception {
         return clienteService.saveCliente(cliente);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente updateCliente(@PathVariable String id, 
    		@RequestBody @NotNull Cliente cliente) throws Exception {
         return clienteService.saveCliente(cliente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateCliente(@PathVariable String id) throws Exception {
         clienteService.deleteCliente(id);
         return true;
    }
    
}
