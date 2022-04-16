package com.tropadepedreiros.Apibanco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tropadepedreiros.Apibanco.model.movimienot;
import com.tropadepedreiros.Apibanco.repository.MovimienotRepository;

@Service
public class MovimienotService {

	@Autowired
	private MovimienotRepository repository;
	
	public movimienot findById(String id) {
		Optional<movimienot> objm = repository.findById(id);
		return objm.orElse(null);
	}
	
	public List<movimienot> findAll(){
		return repository.findAll();
	}
	
	public movimienot update(String id, movimienot updateObj ) {
		movimienot databaseObj = findById(id);
		
		databaseObj.setCartao(updateObj.getCartao());
		databaseObj.setValor(updateObj.getValor());
		databaseObj.setData(updateObj.getData());
		
		return repository.save(databaseObj);
	}
	
	public movimienot create(movimienot obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
}
