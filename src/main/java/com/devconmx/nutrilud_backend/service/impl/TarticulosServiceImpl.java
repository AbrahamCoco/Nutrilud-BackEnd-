package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.TarticulosBuilder;
import com.devconmx.nutrilud_backend.model.TarticulosDTO;
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
        LOG.info("FindAllArticulosService() -> Articulos");
        List<TarticulosVO> listTarticulosVOs = null;
        try {
            listTarticulosVOs = tarticulosRepository.findAll();
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        LOG.info("FindAllArticulosService() -> Articulos: {}", listTarticulosVOs);
        return listTarticulosVOs;
    }

    @Override
    public List<TarticulosVO> findById(int id) throws AppException {
        LOG.info("FindByIdArticulosService() -> Articulos");
        List<TarticulosVO> listTarticulosVOs = null;
        try {
            listTarticulosVOs = tarticulosRepository.findById(id).stream().toList();
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        LOG.info("FindByIdArticulosService() - >Articulos: {}", listTarticulosVOs);
        return listTarticulosVOs;
    }

    @Override
    public void save(TarticulosDTO tarticulosDTO) throws AppException {
        LOG.info("insertArticuloService() -> TarticulosVO: {}", tarticulosDTO);
        TarticulosVO vo = null;
        try {
            vo = TarticulosBuilder.fromDTO(tarticulosDTO);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            UsersVO user = usersRepository.findByNutriologo(tarticulosDTO.getNutriologo_id());
            vo.setTusuario_nutriologo(user);
            tarticulosRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el articulo");
        }
    }
}
