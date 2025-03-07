package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.Tusuario_pacientesVO;

@Repository
public interface Tusuario_pacientesRepository extends JpaRepository<Tusuario_pacientesVO, Integer> {

}
