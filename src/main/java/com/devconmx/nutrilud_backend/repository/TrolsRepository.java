package com.devconmx.nutrilud_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.vos.TrolsVO;

@Repository
public interface TrolsRepository extends JpaRepository<TrolsVO, Integer> {
    TrolsVO findById(int id);

    List<TrolsVO> findAllRols();
}
