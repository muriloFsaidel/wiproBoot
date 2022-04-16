package com.tropadepedreiros.Apibanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tropadepedreiros.Apibanco.model.Usuario;

@Repository //declarando que a interface realiza a manutenção CRUD no banco
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
