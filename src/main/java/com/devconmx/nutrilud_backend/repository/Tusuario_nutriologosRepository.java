package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.vos.Tusuario_nutriologosVO;

@Repository
public interface Tusuario_nutriologosRepository extends JpaRepository<Tusuario_nutriologosVO, Integer> {

}
