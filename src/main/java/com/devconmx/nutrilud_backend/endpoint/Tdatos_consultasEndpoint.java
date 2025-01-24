package com.devconmx.nutrilud_backend.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.Tdatos_consultasDTO;
import com.devconmx.nutrilud_backend.model.Tdatos_consultasVO;
import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.service.Tdatos_consultasServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("tdatos_consultas")
@RestController()
@CrossOrigin(origins = "*")
public class Tdatos_consultasEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(Tdatos_consultasEndpoint.class);

    @Autowired
    private Tdatos_consultasRepository tdatos_consultasRepository;

    @Autowired
    private Tdatos_consultasServices tdatos_consultasServices;

    @GetMapping("/findAgendaByNutriologo")
    public ResponseEntity<ResponseBean<List<Tdatos_consultasVO>>> findAgendaByNutriologo(@RequestParam int id) {
        ResponseEntity<ResponseBean<List<Tdatos_consultasVO>>> response = null;
        LOG.info("findAgendaByNutriologoEndpoint() -> id: {}", id);
        List<Tdatos_consultasVO> listaAgenda = null;
        try {
            listaAgenda = tdatos_consultasServices.findByNutriologo(id);
            response = Utils.response200OK("Datos de agenda encontrados", listaAgenda);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al recuperar los datos de la agenda");
        }
        LOG.info("findAgendaByNutriologoEndpoint() -> response: {}", listaAgenda);
        return response;
    }

    @GetMapping("/findConsultasByPaciente")
    public ResponseEntity<ResponseBean<List<Tdatos_consultasVO>>> findConsultasByPaciente(@RequestParam int id) {
        ResponseEntity<ResponseBean<List<Tdatos_consultasVO>>> response = null;
        LOG.info("findConsultasByPacienteEndpoint() -> id: {}", id);
        List<Tdatos_consultasVO> listaConsultas = null;
        try {
            listaConsultas = tdatos_consultasServices.findByPaciente(id);
            response = Utils.response200OK("Datos de consultas encontrados", listaConsultas);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al recuperar los datos de las consultas");
        }
        LOG.info("findConsultasByPacienteEndpoint() -> response: {}", response);
        return response;
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseBean<Void>> insert(@RequestBody Tdatos_consultasDTO tdatos_consultasDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("insertConsultaEndpoint() -> tdatos_consultasDTO: {}", tdatos_consultasDTO);
        try {
            tdatos_consultasServices.save(tdatos_consultasDTO);
            response = Utils.response200OK("Datos de la consulta guardados");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al guardar los datos de la consulta");
        }
        LOG.info("insertConsultaEndpoint() -> response: {}", response);
        return response;
    }
}
