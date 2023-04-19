package br.unibh.sdm.backend_pessoa.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_pessoas.entidades.Cliente;

@EnableScan
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
    List<Cliente> findByCpf(String cpf);
}
