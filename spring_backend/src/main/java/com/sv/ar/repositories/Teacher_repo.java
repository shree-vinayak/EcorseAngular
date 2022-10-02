package com.sv.ar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.ar.entities.TeacherDetails;

@Repository
public interface Teacher_repo extends JpaRepository<TeacherDetails, String> {

	

}
