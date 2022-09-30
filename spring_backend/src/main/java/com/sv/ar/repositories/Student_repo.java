package com.sv.ar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.ar.entities.StudentDetails;


@Repository
public interface Student_repo extends JpaRepository<StudentDetails, String>{

	@Query(value="select * from StudentDetails s where s.studentclass in (:classslist)",nativeQuery = true)
	List<StudentDetails> getStudentForEnterMarks(@Param("classslist")List<String> classslist);

}
