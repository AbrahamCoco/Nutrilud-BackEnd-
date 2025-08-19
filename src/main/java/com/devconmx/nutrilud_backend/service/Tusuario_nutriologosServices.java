package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.dtos.Tusuario_nutriologosDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_nutriologosVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tusuario_nutriologosServices {
    Tusuario_nutriologosVO insert(Tusuario_nutriologosDTO tusuario_nutriologosDTO) throws AppException;
}
