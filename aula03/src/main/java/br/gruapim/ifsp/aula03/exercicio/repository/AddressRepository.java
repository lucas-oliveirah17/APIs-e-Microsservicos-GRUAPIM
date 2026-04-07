package br.gruapim.ifsp.aula03.exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gruapim.ifsp.aula03.exercicio.model.Address;

//DESAFIO 01 - Criando um Novo Modelo de Dados
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findByContactId(Long contactId);

}
