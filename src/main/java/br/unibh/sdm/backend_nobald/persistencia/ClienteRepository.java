package br.unibh.sdm.backend_nobald.persistencia;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_nobald.entidades.Cliente;

@EnableScan
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findById(String Id);

    void deleteById(String id);
}
