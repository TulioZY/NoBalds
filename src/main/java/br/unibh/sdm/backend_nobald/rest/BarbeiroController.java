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

import br.unibh.sdm.backend_nobald.entidades.Barbeiro;
import br.unibh.sdm.backend_nobald.negocio.BarbeiroService;

/**
 * Classe contendo as definições de serviços REST/JSON para Barbeiro
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "barbeiro")
public class BarbeiroController {
   
    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService){
        this.barbeiroService=barbeiroService;
    }

    @GetMapping(value = "")
    public List<Barbeiro> getBarbeiros(){
        return barbeiroService.getBarbeiros();
    }
    
    @GetMapping(value="{id}")
    public Barbeiro getBarbeiroById(@PathVariable String id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return barbeiroService.getBarbeiroById(id);
        }
        throw new Exception("Barbeiro com codigo "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Barbeiro createBarbeiro(@RequestBody @NotNull Barbeiro barbeiro) throws Exception {
         return barbeiroService.saveBarbeiro(barbeiro);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Barbeiro updateBarbeiro(@PathVariable String id, 
    		@RequestBody @NotNull Barbeiro barbeiro) throws Exception {
         return barbeiroService.saveBarbeiro(barbeiro);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateBarbeiro(@PathVariable String id) throws Exception {
         barbeiroService.deleteBarbeiro(id);
         return true;
    }
    
}
