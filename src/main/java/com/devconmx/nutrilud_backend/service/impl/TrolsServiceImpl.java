package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.TrolsBuilder;
import com.devconmx.nutrilud_backend.model.dtos.TrolsDTO;
import com.devconmx.nutrilud_backend.model.vos.TrolsVO;
import com.devconmx.nutrilud_backend.repository.TrolsRepository;
import com.devconmx.nutrilud_backend.service.TrolsServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class TrolsServiceImpl implements TrolsServices {
    private static final Logger LOG = LoggerFactory.getLogger(TrolsServices.class);

    @Autowired
    private TrolsRepository trolsRepository;

    @Override
    public void save(TrolsDTO trolsDTO) throws AppException {
        LOG.info("insertRolService() -> Rol: {}", trolsDTO);
        TrolsVO vo = null;
        try {
            vo = TrolsBuilder.fromDTO(trolsDTO);
            vo.setEstado(1);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            trolsRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el rol");
        }
    }

    @Override
    public void update(int id, TrolsDTO trolsDTO) throws AppException {
        LOG.info("updateRolService() -> id: {}, Rol: {}", id, trolsDTO);
        TrolsVO vo = null;
        try {
            vo = trolsRepository.findById(id);
            if (vo == null) {
                throw new AppException("El rol no existe");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El rol está deshabilitado");
            }

            vo.setRol(trolsDTO.getRol());
            vo.setEstado(1);
            vo.setUpdated_at(LocalDateTime.now());
            trolsRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al actualizar el rol");
        }
    }

    @Override
    public void delete(int id) throws AppException {
        LOG.info("deleteRolService() -> id: {}", id);
        TrolsVO vo = null;
        try {
            vo = trolsRepository.findById(id);
            if (vo == null) {
                throw new AppException("El rol no existe");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El rol está deshabilitado");
            }

            vo.setEstado(0);
            trolsRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al eliminar el rol");
        }
    }

    @Override
    public TrolsVO findById(int id) throws AppException {
        LOG.info("findRolByIdService() -> id: {}", id);
        TrolsVO vo = null;
        try {
            vo = trolsRepository.findById(id);
            if (vo == null) {
                throw new AppException("El rol no existe");
            }
            if (vo.getEstado() == 0) {
                throw new AppException("El rol está deshabilitado");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar el rol");
        }
        LOG.info("findRolByIdService() -> Rol encontrado");
        return vo;
    }

    @Override
    public List<TrolsVO> findAll() throws AppException {
        LOG.info("findAllRolService()");
        List<TrolsVO> list = null;
        try {
            list = trolsRepository.findAllRols();
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar los roles");
        }
        LOG.info("findAllRolService() -> Roles encontrados");
        return list;
    }

}
