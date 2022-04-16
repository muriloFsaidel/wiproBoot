package com.tropadepedreiros.Apibanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tropadepedreiros.Apibanco.model.movimienot;

@Repository
public interface MovimienotRepository extends JpaRepository<movimienot,String>{

}
