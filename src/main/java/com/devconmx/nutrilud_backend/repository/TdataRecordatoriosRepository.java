package com.devconmx.nutrilud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.vos.TdataRecordatoriosVO;

@Repository
public interface TdataRecordatoriosRepository extends JpaRepository<TdataRecordatoriosVO, Integer> {
    // Define any custom query methods if needed
}
