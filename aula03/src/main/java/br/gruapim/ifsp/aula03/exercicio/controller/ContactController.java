package br.gruapim.ifsp.aula03.exercicio.controller;

import br.gruapim.ifsp.aula03.exercicio.model.Contact;
import br.gruapim.ifsp.aula03.exercicio.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	// EXERCÍCIO 01 - Criando um Novo Endpoint GET
	@GetMapping("/search")
	public ResponseEntity<List<Contact>> searchByName(@RequestParam String nome) {
		// Busca o contato no repositório pelo Nome
		List<Contact> contacts = contactRepository.findByNome(nome);
		
		// Retorna a lista com o status HTTP 200 (OK), mesmo que vazia
		return ResponseEntity.ok(contacts);
	}
	
	// EXERCÍCIO 02 - Implementando um Método PATCH
	@PatchMapping("/{id}")
	public ResponseEntity<Contact> updateContactPartial(
			@PathVariable Long id, 
			@RequestBody Contact contactUpdate) {
		
		// Busca contato no banco, com Optional para que possa receber null
		Optional<Contact> contactOptional = contactRepository.findById(id);
		
		// Se não encontrar contato retorna HTTP Not Found (404)
		if(contactOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		// Contato encontrado, extrai ele
		Contact existingContact = contactOptional.get();
		
		// Atualiza apenas os campos que o usuário enviou
		if (contactUpdate.getNome() != null) {
			existingContact.setNome(contactUpdate.getNome());
		}
		if (contactUpdate.getTelefone() != null) {
			existingContact.setTelefone(contactUpdate.getTelefone());
		}
		if (contactUpdate.getEmail() != null) {
			existingContact.setEmail(contactUpdate.getEmail());
		}
		
		// Salva o contato modificado no banco de dados
		Contact savedContact = contactRepository.save(existingContact);
		
		// Retorna o contato salvo com status HTTP 200 (OK)
		return ResponseEntity.ok(savedContact);	
	}
	
}
