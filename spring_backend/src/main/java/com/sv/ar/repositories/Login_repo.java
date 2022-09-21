package com.sv.ar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.ar.entities.Login;

@Repository
public interface Login_repo  extends JpaRepository<Login, String>{

	
	@Query("select s from Login s where s.username=(:username) ")
	Login loadByUsername( String username);

	
	
}
