package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.Tusuario_adminsVO;

@Repository
public interface Tusuario_adminsRepository extends JpaRepository<Tusuario_adminsVO, Integer> {

}
