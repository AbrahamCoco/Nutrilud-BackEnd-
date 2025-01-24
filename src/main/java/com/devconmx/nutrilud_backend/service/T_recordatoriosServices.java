package com.devconmx.nutrilud_backend.service;

import com.devconmx.nutrilud_backend.model.T_recordatoriosDTO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface T_recordatoriosServices {
    void insert(T_recordatoriosDTO T_recordatoriosDTO) throws AppException;
}
