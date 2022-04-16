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

import com.tropadepedreiros.Apibanco.model.movimienot;
import com.tropadepedreiros.Apibanco.service.MovimienotService;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin("*")
public class MovimienotController {

	@Autowired
	private MovimienotService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<movimienot> getById(@PathVariable String id){
		movimienot obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<movimienot>> getAll(){
		List<movimienot> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<movimienot> post(@RequestBody movimienot m){
		return ResponseEntity.status(HttpStatus.GONE).body(service.create(m));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<movimienot> put(@PathVariable String id, @RequestBody movimienot obj){
		movimienot updatedMovimienot = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMovimienot);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
