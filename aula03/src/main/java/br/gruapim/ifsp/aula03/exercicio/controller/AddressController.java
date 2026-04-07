package br.gruapim.ifsp.aula03.exercicio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gruapim.ifsp.aula03.exercicio.model.Address;
import br.gruapim.ifsp.aula03.exercicio.model.Contact;
import br.gruapim.ifsp.aula03.exercicio.repository.AddressRepository;
import br.gruapim.ifsp.aula03.exercicio.repository.ContactRepository;

//DESAFIO 01 - Criando um Novo Modelo de Dados
@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/contacts/{id}/adresses")
	public ResponseEntity<List<Address>> getAdressesByContactId(
			@PathVariable Long id){
		
		// Verifica se o contato existe
		if(!contactRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		// Lista os endereços a partir do id do contanto recebido
		List<Address> addresses = addressRepository.findByContactId(id);
		
		// Retorna a lista com status HTTP 200 (OK), mesmo que vazia
		return ResponseEntity.ok(addresses);
		
	}
	
	@PostMapping("/contacts/{id}/address")
	public ResponseEntity<Address> addAdressToContact(
			@PathVariable Long id, 
			@RequestBody Address address) {
		
		// Busca contato no banco de dados com Optional, para proteção contra null 
		Optional<Contact> contactOptional = contactRepository.findById(id);
		
		// Se não encontrar contato, retorna HTTP Not Found (404)
		if (contactOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		// Extrai o contato
		Contact contact = contactOptional.get();
		
		// Associa o contato ao novo endereço
		address.setContactId(contact);
		
		// Salva o endereço no banco
		Address savedAddress = addressRepository.save(address);
		
		// Retorna o endereço criado com status HTTP OK (200)
		return ResponseEntity.ok(savedAddress);
	}

}
