package br.unibh.sdm.backend_nobald.persistencia;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_nobald.entidades.Barbeiro;

@EnableScan
public interface BarbeiroRepository extends CrudRepository<Barbeiro, Long>{
    
    Optional<Barbeiro> findByCpf(String cpf);
    Optional<Barbeiro> findById(String id);

    void deleteById (String Id);
}
