package com.devconmx.nutrilud_backend.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.TarticulosVO;
import com.devconmx.nutrilud_backend.repository.TarticulosRepository;
import com.devconmx.nutrilud_backend.service.TarticulosServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class TarticulosServiceImpl implements TarticulosServices {
    private static final Logger LOG = LoggerFactory.getLogger(TarticulosServices.class);

    @Autowired
    TarticulosRepository tarticulosRepository;

    @Override
    public List<TarticulosVO> findAll() throws AppException {
        LOG.info("FindAll->Articulos");
        List<TarticulosVO> listTarticulosVOs = null;
        try {
            listTarticulosVOs = tarticulosRepository.findAll();
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        return listTarticulosVOs;
    }
}
