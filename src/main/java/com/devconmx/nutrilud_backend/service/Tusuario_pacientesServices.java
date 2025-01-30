package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.Tusuario_pacientesDTO;
import com.devconmx.nutrilud_backend.model.Tusuario_pacientesVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tusuario_pacientesServices {
    Tusuario_pacientesVO insert(Tusuario_pacientesDTO tusuario_pacientesDTO) throws AppException;
}
