package br.unibh.sdm.backend_pessoa.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_pessoas.entidades.Servico;

@EnableScan
public interface ServicoRepository extends CrudRepository<Servico, Long>{
    
    List<Servico> findByServicoId(String ServicoId);
}
