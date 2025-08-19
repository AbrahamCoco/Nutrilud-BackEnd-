package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.dtos.T_recordatoriosDTO;
import com.devconmx.nutrilud_backend.model.vos.T_recordatoriosVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface T_recordatoriosServices {
    void insert(T_recordatoriosDTO T_recordatoriosDTO) throws AppException;

    List<T_recordatoriosVO> findRecordatorioByPacienteId(int id) throws AppException;
}
