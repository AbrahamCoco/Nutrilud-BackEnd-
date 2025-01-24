package com.devconmx.nutrilud_backend.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.service.Tdatos_consultasServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tdatos_consultasServiceImpl implements Tdatos_consultasServices {
    private static final Logger LOG = LoggerFactory.getLogger(Tdatos_consultasServices.class);

    @Autowired
    private Tdatos_consultasRepository tdatos_consultasRepository;

    @Override
    public List<Tdatos_consultasVO> findByNutriologo(int id) throws AppException {
        LOG.info("findByNutriologoService() -> Nutriologo: {}", id);
        List<Tdatos_consultasVO> listaAgenda = null;
        try {
            listaAgenda = tdatos_consultasRepository.findByNutriologoVO(id);
            if (listaAgenda == null) {
                throw new AppException("No se encontraron datos de la agenda");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar la agenda del nutriologo");
        }
        return listaAgenda;
    }

    @Override
    public List<Tdatos_consultasVO> findByPaciente(int id) throws AppException {
        LOG.info("findByPacienteService() -> Paciente: {}", id);
        List<Tdatos_consultasVO> listaAgenda = null;
        try {
            listaAgenda = tdatos_consultasRepository.findByPacienteVO(id);
            if (listaAgenda == null) {
                throw new AppException("No se encontraron datos de la agenda");
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar la agenda del paciente");
        }
        return listaAgenda;
    }

}
