package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.dtos.Tdatos_consultasDTO;
import com.devconmx.nutrilud_backend.model.vos.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tdatos_consultasServices {
    List<Tdatos_consultasVO> findByNutriologo(int id) throws AppException;

    List<Tdatos_consultasVO> findByPaciente(int id) throws AppException;

    void save(Tdatos_consultasDTO tdatos_consultasDTO) throws AppException;
}