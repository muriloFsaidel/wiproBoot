package com.tropadepedreiros.Apibanco.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity//declarando classe como entidade
@Table(name = "movintacoes")//declarando que classe vai corresponder a tabela movintacoes
public class movimienot implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id//declarando atributo como indice pk da tabela
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")//gerando id únicos hexadecimais
	String id;
	
	String cartao;
	
	Double valor;
	
	Calendar data;
	
	public movimienot() {
		super();
	}
	
	public movimienot(String cartao, Double valor, Calendar data) {
		super();
		this.cartao = cartao;
		this.valor = valor;
		this.data = data;		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartao, data, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		movimienot other = (movimienot) obj;
		return Objects.equals(cartao, other.cartao) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
	}
	

	
	
}
