package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.Tusuario_nutriologosBuilder;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_nutriologosDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_nutriologosVO;
import com.devconmx.nutrilud_backend.repository.Tusuario_nutriologosRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_nutriologosServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tusuario_nutriologosServiceImpl implements Tusuario_nutriologosServices {
    private static final Logger LOG = LoggerFactory.getLogger(Tusuario_nutriologosServices.class);

    @Autowired
    private Tusuario_nutriologosRepository tusuario_nutriologosRepository;

    @Override
    public Tusuario_nutriologosVO insert(Tusuario_nutriologosDTO tusuario_nutriologosDTO) throws AppException {
        LOG.info("insertTusuario_nutriologosService() -> Nutriologo: {}", tusuario_nutriologosDTO);
        Tusuario_nutriologosVO vo = null;
        try {
            vo = Tusuario_nutriologosBuilder.fromDTO(tusuario_nutriologosDTO);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            tusuario_nutriologosRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el nutriologo");
        }
        LOG.info("insertTusuario_nutriologosService() -> Nutriologo insertado");
        return vo;
    }
}
