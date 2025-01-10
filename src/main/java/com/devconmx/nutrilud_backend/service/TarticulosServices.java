package com.devconmx.nutrilud_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import com.devconmx.nutrilud_backend.model.TarticulosVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface TarticulosServices {
    List<TarticulosVO> findAll() throws AppException;

    List<TarticulosVO> findById(Long id) throws AppException;

    void insert(Long nutriologo_id, String contenido, String foto, LocalDateTime created_at, LocalDateTime updated_at)
            throws AppException;
}
