package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.Tusuario_pacientesBuilder;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_pacientesDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_pacientesVO;
import com.devconmx.nutrilud_backend.repository.Tusuario_pacientesRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_pacientesServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tusuario_pacientesServiceImpl implements Tusuario_pacientesServices {
    private static final Logger LOG = LoggerFactory.getLogger(Tusuario_pacientesServices.class);

    @Autowired
    private Tusuario_pacientesRepository tusuario_pacientesRepository;

    @Override
    public Tusuario_pacientesVO insert(Tusuario_pacientesDTO tusuario_pacientesDTO) throws AppException {
        LOG.info("insertTusuario_pacientesService() -> Paciente: {}", tusuario_pacientesDTO);
        Tusuario_pacientesVO vo = null;
        try {
            vo = Tusuario_pacientesBuilder.fromDTO(tusuario_pacientesDTO);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            tusuario_pacientesRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el paciente");
        }
        return vo;
    }
}
