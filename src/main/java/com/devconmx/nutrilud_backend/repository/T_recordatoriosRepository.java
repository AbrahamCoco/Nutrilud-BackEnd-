package com.devconmx.nutrilud_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devconmx.nutrilud_backend.model.vos.T_recordatoriosVO;

@Repository
public interface T_recordatoriosRepository extends JpaRepository<T_recordatoriosVO, Integer> {
    List<T_recordatoriosVO> findRecordatorioByPacienteId(int id);
}
