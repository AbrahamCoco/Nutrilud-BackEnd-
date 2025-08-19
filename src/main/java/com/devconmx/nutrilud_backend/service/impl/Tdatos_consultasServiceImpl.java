package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.beans.AgendaBean;
import com.devconmx.nutrilud_backend.model.beans.ConsultasBean;
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
    public List<AgendaBean> findByNutriologo(int id) throws AppException {
        LOG.info("findByNutriologoService() -> Nutriologo: {}", id);
        List<Tdatos_consultasVO> listaAgenda;
        List<AgendaBean> agendaBeans = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            listaAgenda = tdatos_consultasRepository.findByNutriologoVO(id);
            if (listaAgenda == null) {
                throw new AppException("No se encontraron datos de la agenda");
            }

            listaAgenda.forEach(consulta -> {
                LocalDateTime hoy = LocalDateTime.now();
                LocalDateTime fechaConsulta = LocalDateTime.parse(consulta.getSiguiente_consulta(), formatter);

                if (fechaConsulta.isBefore(hoy)) {
                    return;
                }

                AgendaBean bean = new AgendaBean();
                bean.setId_paciente(consulta.getTusuario_paciente().getTusuario_pacientes().getId());
                bean.setSiguiente_consulta(consulta.getSiguiente_consulta());
                bean.setNombre(consulta.getTusuario_paciente().getNombre());
                bean.setPrimer_apellido(consulta.getTusuario_paciente().getPrimer_apellido());
                bean.setSegundo_apellido(consulta.getTusuario_paciente().getSegundo_apellido());
                agendaBeans.add(bean);
            });

            if (agendaBeans.isEmpty()) {
                throw new AppException("No hay consultas pendientes.");
            }

        } catch (Exception e) {
            Utils.raise(e, "Error al buscar la agenda del nutriologo");
        }
        LOG.info("findByNutriologoService() -> Agenda encontrada");
        return agendaBeans;
    }

    @Override
    public List<ConsultasBean> findByPaciente(int id) throws AppException {
        LOG.info("findByPacienteService() -> Paciente: {}", id);
        List<Tdatos_consultasVO> listaAgenda = null;
        List<ConsultasBean> consultas = new ArrayList<>();
        try {
            listaAgenda = tdatos_consultasRepository.findByPacienteVO(id);
            if (listaAgenda == null) {
                throw new AppException("No se encontraron datos de la agenda");
            }

            listaAgenda.forEach(consulta -> {
                ConsultasBean bean = new ConsultasBean();
                bean.setId(consulta.getId());
                bean.setPeso(consulta.getPeso());
                bean.setEstatura(consulta.getEstatura());
                bean.setPorcentaje_grasa(consulta.getPorcentaje_grasa());
                bean.setPorcentaje_musculo(consulta.getPorcentaje_musculo());
                bean.setImc(consulta.getImc());
                bean.setCircunferencia_cintura(consulta.getCircunferencia_cintura());
                bean.setCircunferencia_cadera(consulta.getCircunferencia_cadera());
                bean.setCircunferencia_brazo(consulta.getCircunferencia_brazo());
                bean.setPliegue_bicipital(consulta.getPliegue_bicipital());
                bean.setPliegue_tricipital(consulta.getPliegue_tricipital());
                bean.setGlucosa(consulta.getGlucosa());
                bean.setColesterol(consulta.getColesterol());
                bean.setTrigliceridos(consulta.getTrigliceridos());
                bean.setPresion_arterial(consulta.getPresion_arterial());
                bean.setFecha_medicion(consulta.getFecha_medicion());
                consultas.add(bean);
            });
        } catch (Exception e) {
            Utils.raise(e, "Error al buscar la agenda del paciente");
        }
        LOG.info("findByPacienteService() -> Agenda encontrada");
        return consultas;
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

            double imc = dosdecimales(imc(tdatos_consultasDTO.getPeso(), tdatos_consultasDTO.getEstatura()));
            vo.setImc(imc);

            String sexo = paciente.getTusuario_pacientes().getSexo();
            int edad = edad(paciente.getTusuario_pacientes().getFecha_nacimiento());
            double porcentaje_grasa = dosdecimales(porcentaje_grasa(sexo, imc, edad));
            vo.setPorcentaje_grasa(porcentaje_grasa);

            double masa_muscular = dosdecimales(masaMuscularTotal(tdatos_consultasDTO.getPeso(), porcentaje_grasa, tdatos_consultasDTO.getCircunferencia_brazo(), tdatos_consultasDTO.getPliegue_tricipital(), sexo));
            vo.setPorcentaje_musculo(masa_muscular);
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

    public double masaMuscularTotal(double peso, double porcentajeGrasa, double circunferenciaBrazo, double pliegueTricipital, String sexo) {
        double grasaKg = peso * (porcentajeGrasa / 100.0);

        double lbm = peso - grasaKg;

        double masaMuscular = lbm * 0.55;

        double pliegueCm = pliegueTricipital / 10.0;
        double cmac = circunferenciaBrazo - Math.PI * pliegueCm;
        double areaMuscularBrazo = Math.pow(cmac, 2) / (4 * Math.PI);

        if (sexo.equalsIgnoreCase("Masculino")) {
            areaMuscularBrazo -= 10;
        } else {
            areaMuscularBrazo -= 6.5;
        }
        double factorAjuste = 1 + (areaMuscularBrazo / 1000.0);
        masaMuscular *= factorAjuste;

        return masaMuscular;
    }

    public int edad(LocalDate fecha_nacimiento) {
        LocalDateTime fecha_actual = LocalDateTime.now();
        return fecha_actual.getYear() - fecha_nacimiento.getYear();
    }

    public static double dosdecimales(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
