package com.sv.ar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.ar.compositeId.MarksId;
import com.sv.ar.entities.MarksTable;


@Repository
public interface MarksTable_repo extends JpaRepository<MarksTable, MarksId> {

	@Query(value="select * from markstable m where  m.studentusername in (:studentUsernameList) and m.subject1marks is null ",nativeQuery = true)
	List<MarksTable> getStudentForSubject1(@Param("studentUsernameList")List<String> studentUsernameList);

	@Query(value="select * from markstable m where  m.studentusername in (:studentUsernameList) and m.subject2marks is null ",nativeQuery = true)
	List<MarksTable> getStudentForSubject2(List<String> studentUsernameList);
	
	@Query(value="select * from markstable m where  m.studentusername in (:studentUsernameList) and m.subject3marks is null ",nativeQuery = true)
	List<MarksTable> getStudentForSubject3(List<String> studentUsernameList);

}
