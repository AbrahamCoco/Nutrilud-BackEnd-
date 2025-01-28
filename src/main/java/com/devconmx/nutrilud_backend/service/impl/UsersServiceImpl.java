package com.devconmx.nutrilud_backend.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class UsersServiceImpl implements UsersServices {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServices.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UsersVO> findAllPacientes() throws AppException {
        LOG.info("findAllPacientes()");
        List<UsersVO> vo = null;
        try {
            vo = usersRepository.findByPaciente();
            if (vo == null) {
                throw new AppException("No se encontraron pacientes");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar pacientes");
        }
        return vo;
    }

    @Override
    public UsersVO findByIdPaciente(int id) throws AppException {
        LOG.info("findByIdPaciente() -> id: {}", id);
        UsersVO vo = null;
        try {
            vo = usersRepository.findByIdPaciente(id);
            if (vo == null) {
                throw new AppException("No se encontro el paciente");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El paciente esta deshabilitado");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar paciente");
        }
        return vo;
    }

    @Override
    public void deleteByIdPaciente(int id) throws AppException {
        LOG.info("deleteByIdPaciente() -> id: {}", id);
        UsersVO vo = null;
        try {
            vo = usersRepository.findByIdPaciente(id);
            if (vo == null) {
                throw new AppException("No se encontro el paciente");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El paciente esta deshabilitado");
            }
            vo.setEstado(0);
            usersRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al eliminar paciente");
        }
    }
}
