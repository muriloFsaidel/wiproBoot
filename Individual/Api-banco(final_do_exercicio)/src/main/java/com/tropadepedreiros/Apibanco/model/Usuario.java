package com.tropadepedreiros.Apibanco.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

//(holder)
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name= "uuid2", strategy = "uuid2")//uuid é a geração de id único hexadecimal
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO INCREMENT
	String id;
	
	String nome;
	
	String email;
	
	String senha;
	
	String sobrenome;
	
	String cartao;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String email, String senha, String sobrenome, String cartao) {
		
		super();
		//this === objeto instanciado
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sobrenome = sobrenome;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartao, email, id, nome, senha, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cartao, other.cartao) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	
	
	
}