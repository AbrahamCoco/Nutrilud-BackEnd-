package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.TrolsVO;

@Repository
public interface TrolsRepository extends JpaRepository<TrolsVO, Integer> {
    TrolsVO findById(int id);
}
