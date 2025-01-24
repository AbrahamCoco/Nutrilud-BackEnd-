package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.T_recordatoriosVO;

@Repository
public interface T_recordatoriosRepository extends JpaRepository<T_recordatoriosVO, Integer> {

}
