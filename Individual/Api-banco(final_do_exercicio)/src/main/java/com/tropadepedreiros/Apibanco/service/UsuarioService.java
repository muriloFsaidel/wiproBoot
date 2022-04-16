package com.tropadepedreiros.Apibanco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tropadepedreiros.Apibanco.model.Usuario;
import com.tropadepedreiros.Apibanco.repository.UsuarioRepository;

@Service//declarando classe como serviço entre controller e repository
public class UsuarioService {

	@Autowired //instancia automaticamente o objeto
	private UsuarioRepository repository;
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario update(String id, Usuario updateObj) {
		//objeto do banco de dados
		Usuario databaseObj = findById(id);
		//atribuindo aos atributos do objeto do banco os novos atributos da atualização
		databaseObj.setNome(updateObj.getNome());
		databaseObj.setSobrenome(updateObj.getSobrenome());
		databaseObj.setEmail(updateObj.getEmail());
		databaseObj.setSenha(updateObj.getSenha());
		databaseObj.setCartao(updateObj.getCartao());
		return repository.save(databaseObj);
	}
	
	public Usuario create(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
}
