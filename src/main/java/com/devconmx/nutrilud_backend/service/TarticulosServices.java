package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.TarticulosVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface TarticulosServices {
    List<TarticulosVO> findAll() throws AppException;
}
