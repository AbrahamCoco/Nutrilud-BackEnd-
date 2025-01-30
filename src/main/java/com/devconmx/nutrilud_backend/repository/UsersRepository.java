package com.devconmx.nutrilud_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Integer> {
    UsersVO login(@Param("usuario") String usuario, @Param("contrasenia") String contrasenia);

    UsersVO findByNutriologo(int id);

    List<UsersVO> findByPaciente();

    UsersVO findByIdPaciente(int id);

    UsersVO findByIdNutriologo(int id);

    UsersVO findById(int id);

    UsersVO findByUser(String usuario);
}
