package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.builders.Tdatos_consultasBuilder;
import com.devconmx.nutrilud_backend.model.dtos.Tdatos_consultasDTO;
import com.devconmx.nutrilud_backend.model.vos.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.Tdatos_consultasServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class Tdatos_consultasServiceImpl implements Tdatos_consultasServices {
    private static final Logger LOG = LoggerFactory.getLogger(Tdatos_consultasServices.class);

    @Autowired
    private Tdatos_consultasRepository tdatos_consultasRepository;

    @Autowired
    private UsersRepository usersRepository;

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

    @Override
    public void save(Tdatos_consultasDTO tdatos_consultasDTO) throws AppException {
        LOG.info("saveConsultaService() -> Consulta: {}", tdatos_consultasDTO);
        Tdatos_consultasVO vo = null;
        try {
            vo = Tdatos_consultasBuilder.fromDTO(tdatos_consultasDTO);
            UsersVO nutriologo = usersRepository.findByIdNutriologo(tdatos_consultasDTO.getNutriologo_id());
            vo.setTusuario_nutriologo(nutriologo);
            UsersVO paciente = usersRepository.findByIdPaciente(tdatos_consultasDTO.getPaciente_id());
            vo.setTusuario_paciente(paciente);

            double imc = imc(tdatos_consultasDTO.getPeso(), tdatos_consultasDTO.getEstatura());
            vo.setImc(imc);

            String sexo = paciente.getTusuario_pacientes().getSexo();
            int edad = edad(paciente.getTusuario_pacientes().getFecha_nacimiento());
            double porcentaje_grasa = porcentaje_grasa(sexo, imc, edad);
            vo.setPorcentaje_grasa(porcentaje_grasa);

            double area_muscular_brazo = area_muscular_brazo(tdatos_consultasDTO.getCircunferencia_brazo(),
                    porcentaje_grasa, sexo);
            vo.setPorcentaje_musculo(area_muscular_brazo);
            vo.setPresion_arterial(tdatos_consultasDTO.getPresion_arterial());
            vo.setTrigliceridos(tdatos_consultasDTO.getTrigliceridos());

            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            tdatos_consultasRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al guardar la consulta");
        }
    }

    public double imc(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    public double porcentaje_grasa(String sexo, double imc, int edad) {
        double porcentaje_grasa = 0;
        if (sexo.equals("Masculino")) {
            porcentaje_grasa = (1.2 * imc) + (0.23 * edad) - 16.2;
        } else {
            porcentaje_grasa = (1.2 * imc) + (0.23 * edad) - 5.4;
        }
        return porcentaje_grasa;
    }

    public double area_muscular_brazo(double circunferencia_brazo, double pliegue_tricipital, String sexo) {
        double area_muscular_brazo = 0;
        if (sexo.equals("Masculino")) {
            area_muscular_brazo = (Math.pow(circunferencia_brazo - area_muscular_brazo * Math.PI, 2) / (4 * Math.PI)
                    - 10);
        } else {
            area_muscular_brazo = (Math.pow(circunferencia_brazo - area_muscular_brazo * Math.PI, 2) / (4 * Math.PI)
                    - 6.5);
        }
        return area_muscular_brazo;
    }

    public int edad(LocalDateTime fecha_nacimiento) {
        LocalDateTime fecha_actual = LocalDateTime.now();
        return fecha_actual.getYear() - fecha_nacimiento.getYear();
    }
}
