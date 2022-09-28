package com.sv.ar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.ar.entities.StudentDetails;


@Repository
public interface Student_repo extends JpaRepository<StudentDetails, String>{

}