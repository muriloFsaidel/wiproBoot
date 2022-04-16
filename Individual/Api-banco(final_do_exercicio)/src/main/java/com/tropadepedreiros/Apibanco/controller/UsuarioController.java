package com.tropadepedreiros.Apibanco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tropadepedreiros.Apibanco.model.Usuario;
import com.tropadepedreiros.Apibanco.service.UsuarioService;

@RestController//declarando que a classe UsuarioController vai ser responsável pelas requisições
@RequestMapping("/usuarios")//declarando que a classe UsuarioController vai atender as requisições pela rota /usuarios
@CrossOrigin("*")//eclarando que a classe UsuarioController vai atender as requisições também pela rota vazia
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable String id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> put(@PathVariable String id, @RequestBody Usuario obj){
		Usuario updatedUser = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
