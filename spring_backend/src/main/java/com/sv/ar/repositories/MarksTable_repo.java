package com.sv.ar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

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

	
	@Transactional
	@Modifying
	@Query(value=" update  markstable m  set m.subject1marks=(:marks) where m.studentusername = (:studentUsername) and m.examtype=(:examptype)",nativeQuery = true)
	int updateMarksForSubject1(String studentUsername, String marks, String examptype);
	
	@Transactional
	@Modifying
	@Query(value=" update  markstable m  set m.subject2marks=(:marks) where m.studentusername = (:studentUsername) and m.examtype=(:examptype)",nativeQuery = true)
	int updateMarksForSubject2(String studentUsername, String marks, String examptype);
	
	@Transactional
	@Modifying
	@Query(value=" update  markstable m  set m.subject3marks=(:marks) where m.studentusername = (:studentUsername) and m.examtype=(:examptype)",nativeQuery = true)
	int updateMarksForSubject3(String studentUsername, String marks, String examptype);
 
	
	@Query(value="select * from markstable m where  m.studentusername=(:studentusername) and m.examtype=(:examtype)")
	MarksTable getResultForExamtype(String studentusername, String examtype);

}
