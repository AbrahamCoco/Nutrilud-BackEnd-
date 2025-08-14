package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.T_recordatoriosBuilder;
import com.devconmx.nutrilud_backend.model.dtos.T_recordatoriosDTO;
import com.devconmx.nutrilud_backend.model.vos.T_recordatoriosVO;
import com.devconmx.nutrilud_backend.model.vos.TdataRecordatoriosVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.repository.T_recordatoriosRepository;
import com.devconmx.nutrilud_backend.repository.TdataRecordatoriosRepository;
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

    @Autowired
    private TdataRecordatoriosRepository tdataRecordatoriosRepository;

    @Override
    public void insert(T_recordatoriosDTO t_recordatoriosDTO) throws AppException {
        LOG.info("insertRecordatorioService() -> T_recordatoriosDTO");
        T_recordatoriosVO vo = null;
        TdataRecordatoriosVO dataVO = null;
        try {
            vo = T_recordatoriosBuilder.fromDTO(t_recordatoriosDTO);
            UsersVO nutriologo = usersRepository.findByIdNutriologo(t_recordatoriosDTO.getNutriologo_id());
            vo.setTusuario_nutriologo(nutriologo);
            UsersVO paciente = usersRepository.findByIdPaciente(t_recordatoriosDTO.getPaciente_id());
            vo.setTusuario_paciente(paciente);

            vo.setOtros(t_recordatoriosDTO.getOtros());
            vo.setObservaciones(t_recordatoriosDTO.getObservaciones());

            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            T_recordatoriosVO id = t_recordatoriosRepository.save(vo);

            var dataList = t_recordatoriosDTO.getTdata_recordatorio();
            if (dataList == null 
                || dataList.getComida() == null 
                || dataList.getHora() == null 
                || dataList.getLugar() == null 
                || dataList.getAlimentos() == null 
                || dataList.getPorciones() == null 
                || dataList.getMarca() == null 
                || dataList.getPreparacion() == null) {
                throw new AppException("Los datos de tdata_recordatorio son inválidos o incompletos.");
            }

            int size = dataList.getComida().size();

            for (int i = 0; i < size; i++) {
                dataVO = new TdataRecordatoriosVO();

                dataVO.setT_recordatorio(id);
                dataVO.setComida(dataList.getComida().get(i));
                dataVO.setHora(dataList.getHora().get(i));
                dataVO.setLugar(dataList.getLugar().get(i));
                dataVO.setAlimentos(dataList.getAlimentos().get(i));
                dataVO.setPorciones(dataList.getPorciones().get(i));
                dataVO.setMarca(dataList.getMarca().get(i));
                dataVO.setPreparacion(dataList.getPreparacion().get(i));
                dataVO.setCreated_at(LocalDateTime.now());
                dataVO.setUpdated_at(LocalDateTime.now());

                tdataRecordatoriosRepository.save(dataVO);
            }
            LOG.info("Recordatorio insertado correctamente");
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el recordatorio");
        }
    }

    @Override
    public List<T_recordatoriosVO> findRecordatorioByPacienteId(int id) throws AppException {
        LOG.info("findRecordatorioByPacienteId() -> id: {}", id);
        List<T_recordatoriosVO> listRecordatorio = Collections.emptyList();
        try {
            listRecordatorio = t_recordatoriosRepository.findRecordatorioByPacienteId(id);
            if (listRecordatorio.isEmpty()) {
                throw new AppException("No se encontraron recordatorios para el paciente con id: " + id);
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar recordatorios por id de paciente");
        }
        LOG.info("Recordatorios encontrados: {}", listRecordatorio.size());
        return listRecordatorio;
    }
}
