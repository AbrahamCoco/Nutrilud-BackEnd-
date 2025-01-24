package com.devconmx.nutrilud_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.service.Tdatos_consultasServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tdatos_consultasServiceImpl implements Tdatos_consultasServices {
    @Autowired
    private Tdatos_consultasRepository tdatos_consultasRepository;

    @Override
    public List<Tdatos_consultasVO> findByNutriologo(int id) throws AppException {
        List<Tdatos_consultasVO> listaAgenda = null;
        try {
            listaAgenda = tdatos_consultasRepository.findByNutriologoVO(id);
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar la agenda del nutriologo");
        }
        return listaAgenda;
    }

}
