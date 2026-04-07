package br.gruapim.ifsp.aula03.exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gruapim.ifsp.aula03.exercicio.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	List<Contact> findByNome(String nome);

}
