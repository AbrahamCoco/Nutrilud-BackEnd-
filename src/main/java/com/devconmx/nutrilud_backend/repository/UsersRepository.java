package com.devconmx.nutrilud_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Long> {
    List<UsersVO> verifyUserRepository(@Param("usuario") String usuario, @Param("contrasenia") String contrasenia);
}
