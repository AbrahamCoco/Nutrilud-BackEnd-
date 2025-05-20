package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.Tusuario_adminsBuilder;
import com.devconmx.nutrilud_backend.model.dtos.Tusuario_adminsDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_adminsVO;
import com.devconmx.nutrilud_backend.repository.Tusuario_adminsRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_adminsServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tusuario_adminsServiceImpl implements Tusuario_adminsServices {
    private static final Logger LOG = LoggerFactory.getLogger(Tusuario_adminsServices.class);

    @Autowired
    private Tusuario_adminsRepository tusuario_adminsRepository;

    @Override
    public Tusuario_adminsVO insert(Tusuario_adminsDTO tusuario_adminsDTO) throws AppException {
        LOG.info("insertTusuario_adminService() -> Admin: {}", tusuario_adminsDTO);
        Tusuario_adminsVO vo = null;
        try {
            vo = Tusuario_adminsBuilder.fromDTO(tusuario_adminsDTO);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            tusuario_adminsRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el administrador");
        }
        return vo;
    }

}
