package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.beans.ArticulosBean;
import com.devconmx.nutrilud_backend.model.dtos.TarticulosDTO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface TarticulosServices {
    void save(TarticulosDTO tarticulosDTO) throws AppException;

    List<ArticulosBean> findAll() throws AppException;

    ArticulosBean findById(int id) throws AppException;
}
