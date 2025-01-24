package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.T_recordatoriosDTO;
import com.devconmx.nutrilud_backend.repository.T_recordatoriosRepository;
import com.devconmx.nutrilud_backend.service.T_recordatoriosServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("t_recordatorios")
@RestController()
@CrossOrigin(origins = "*")
public class T_recordatoriosEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(T_recordatoriosEndpoint.class);

    @Autowired
    private T_recordatoriosRepository t_recordatoriosRepository;

    @Autowired
    private T_recordatoriosServices t_recordatoriosServices;

    @PostMapping("/insert")
    public ResponseEntity<ResponseBean<Void>> insert(@RequestBody T_recordatoriosDTO t_recordatoriosDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("insertRecordatorioEndpoint() -> T_recordatoriosDTO: {}", t_recordatoriosDTO);
        try {
            t_recordatoriosServices.insert(t_recordatoriosDTO);
            response = Utils.response200OK("Recordatorio guardado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al guardar el recordatorio");
        }
        LOG.info("insertRecordatorioEndpoint() -> response: {}", response);
        return response;
    }
}
