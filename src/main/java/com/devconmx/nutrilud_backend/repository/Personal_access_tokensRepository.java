package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.Personal_access_tokenVO;

@Repository
public interface Personal_access_tokensRepository extends JpaRepository<Personal_access_tokenVO, Long> {

}
