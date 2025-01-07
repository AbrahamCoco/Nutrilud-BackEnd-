package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.Tusuario_pacientesRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_pacientesServices;

@RequestMapping("tusuario_pacientes")
@RestController()
@CrossOrigin(origins = "*")
public class Tusuario_pacientesEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(Tusuario_pacientesEndpoint.class);

    @Autowired
    private Tusuario_pacientesRepository tusuario_pacientesRepository;

    @Autowired
    private Tusuario_pacientesServices tusuario_pacientesServices;
}
