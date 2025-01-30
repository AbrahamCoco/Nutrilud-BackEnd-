package com.devconmx.nutrilud_backend.service;

import java.util.List;

import com.devconmx.nutrilud_backend.model.TrolsDTO;
import com.devconmx.nutrilud_backend.model.TrolsVO;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

public interface TrolsServices {
    void save(TrolsDTO trolsDTO) throws AppException;

    void update(int id, TrolsDTO trolsDTO) throws AppException;

    void delete(int id) throws AppException;

    TrolsVO findById(int id) throws AppException;

    List<TrolsVO> findAll() throws AppException;
}
