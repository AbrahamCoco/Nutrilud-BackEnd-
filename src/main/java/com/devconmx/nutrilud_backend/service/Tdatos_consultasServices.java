package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.beans.AgendaBean;
import com.devconmx.nutrilud_backend.model.beans.ConsultasBean;
import com.devconmx.nutrilud_backend.model.dtos.Tdatos_consultasDTO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tdatos_consultasServices {
    List<AgendaBean> findByNutriologo(int id) throws AppException;

    List<ConsultasBean> findByPaciente(int id) throws AppException;

    void save(Tdatos_consultasDTO tdatos_consultasDTO) throws AppException;
}