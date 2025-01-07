package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Long> {

}
