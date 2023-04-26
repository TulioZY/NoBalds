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

import br.unibh.sdm.backend_pessoas.entidades.Servico;
import br.unibh.sdm.backend_nobald.negocio.ServicoService;

/**
 * Classe contendo as definições de serviços REST/JSON para Servico
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "servico")
public class ServicoController {
   
    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService){
        this.servicoService=servicoService;
    }

    @GetMapping(value = "")
    public List<Servico> getServicos(){
        return servicoService.getServicos();
    }
    
    @GetMapping(value="{id}")
    public Servico getServicoById(@PathVariable String id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return servicoService.getServicoById(id);
        }
        throw new Exception("Servico com codigo "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Servico createServico(@RequestBody @NotNull Servico servico) throws Exception {
         return servicoService.saveServico(servico);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Servico updateServico(@PathVariable String id, 
    		@RequestBody @NotNull Servico servico) throws Exception {
         return servicoService.saveServico(servico);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateServico(@PathVariable String id) throws Exception {
         servicoService.deleteServico(id);
         return true;
    }
    
}
