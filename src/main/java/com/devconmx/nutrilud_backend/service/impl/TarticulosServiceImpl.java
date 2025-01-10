package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.TarticulosBuilder;
import com.devconmx.nutrilud_backend.model.TarticulosVO;
import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.repository.TarticulosRepository;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.TarticulosServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class TarticulosServiceImpl implements TarticulosServices {
    private static final Logger LOG = LoggerFactory.getLogger(TarticulosServices.class);

    @Autowired
    private TarticulosRepository tarticulosRepository;

    @Autowired
    private UsersRepository usersRepository;

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

    @Override
    public List<TarticulosVO> findById(Long id) throws AppException {
        LOG.info("FindById->Articulos");
        List<TarticulosVO> listTarticulosVOs = null;
        try {
            listTarticulosVOs = tarticulosRepository.findById(id).stream().toList();
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        LOG.info("FindById->Articulos: {}", listTarticulosVOs);
        return listTarticulosVOs;
    }

    @Override
    public void insert(Long nutriologo_id, String contenido, String foto, LocalDateTime created_at,
            LocalDateTime updated_at)
            throws AppException {
        LOG.info("InsertServices -> Articulos: {} {} {} {} {}", nutriologo_id, contenido, foto, created_at, updated_at);
        try {
            UsersVO usersVO = usersRepository.findById(nutriologo_id).get();
            TarticulosVO tarticulosVO = new TarticulosVO();
            tarticulosVO.setTusuario_nutriologo(usersVO);
            tarticulosVO.setContenido(contenido);
            tarticulosVO.setFoto(foto);
            tarticulosVO.setCreated_at(created_at);
            tarticulosVO.setUpdated_at(created_at);
            TarticulosVO tarticulosVOInserted = tarticulosRepository.save(tarticulosVO);
            TarticulosBuilder.fromVO(tarticulosVOInserted);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el articulo");
        }
    }
}
