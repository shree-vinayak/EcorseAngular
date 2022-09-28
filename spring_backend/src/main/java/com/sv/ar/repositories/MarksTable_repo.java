package com.sv.ar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.ar.compositeId.MarksId;
import com.sv.ar.entities.MarksTable;


@Repository
public interface MarksTable_repo extends JpaRepository<MarksTable, MarksId> {

}
