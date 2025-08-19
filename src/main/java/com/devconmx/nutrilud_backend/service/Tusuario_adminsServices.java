package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.dtos.Tusuario_adminsDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_adminsVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface Tusuario_adminsServices {
    Tusuario_adminsVO insert(Tusuario_adminsDTO tusuario_adminsDTO) throws AppException;
}
