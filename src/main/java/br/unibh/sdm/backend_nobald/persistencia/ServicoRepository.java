package br.unibh.sdm.backend_nobald.persistencia;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_nobald.entidades.Servico;

@EnableScan
public interface ServicoRepository extends CrudRepository<Servico, String>{
    
    Optional<Servico> findById(String id);
}
