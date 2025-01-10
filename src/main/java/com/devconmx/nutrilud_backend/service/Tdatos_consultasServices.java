package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tdatos_consultasServices {
    List<Tdatos_consultasVO> findByNutriologo(Integer id) throws AppException;
}
