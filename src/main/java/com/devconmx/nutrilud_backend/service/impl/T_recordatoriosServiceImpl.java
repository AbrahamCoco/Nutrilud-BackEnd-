package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.T_recordatoriosBuilder;
import com.devconmx.nutrilud_backend.model.dtos.T_recordatoriosDTO;
import com.devconmx.nutrilud_backend.model.vos.T_recordatoriosVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.repository.T_recordatoriosRepository;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.T_recordatoriosServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class T_recordatoriosServiceImpl implements T_recordatoriosServices {
    private static final Logger LOG = LoggerFactory.getLogger(T_recordatoriosServices.class);

    @Autowired
    private T_recordatoriosRepository t_recordatoriosRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void insert(T_recordatoriosDTO t_recordatoriosDTO) throws AppException {
        LOG.info("insertRecordatorioService() -> T_recordatoriosDTO: {}", t_recordatoriosDTO);
        T_recordatoriosVO vo = null;
        try {
            vo = T_recordatoriosBuilder.fromDTO(t_recordatoriosDTO);
            UsersVO nutriologo = usersRepository.findByIdNutriologo(t_recordatoriosDTO.getNutriologo_id());
            vo.setTusuario_nutriologo(nutriologo);
            UsersVO paciente = usersRepository.findByIdPaciente(t_recordatoriosDTO.getPaciente_id());
            vo.setTusuario_paciente(paciente);

            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            t_recordatoriosRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el recordatorio");
        }
    }

    @Override
    public List<T_recordatoriosVO> findRecordatorioByPacienteId(int id) throws AppException {
        LOG.info("findRecordatorioByPacienteId() -> id: {}", id);
        List<T_recordatoriosVO> listRecordatorio = null;
        try {
            listRecordatorio = t_recordatoriosRepository.findRecordatorioByPacienteId(id);
            if (listRecordatorio.isEmpty()) {
                throw new AppException("No se encontraron recordatorios para el paciente con id: " + id);
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar recordatorios por id de paciente");
        }
        return listRecordatorio;
    }
}
