package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.Tdatos_consultasRepository;
import com.devconmx.nutrilud_backend.service.Tdatos_consultasServices;

@RequestMapping("tdatos_consultas")
@RestController()
@CrossOrigin(origins = "*")
public class Tdatos_consultasEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(Tdatos_consultasEndpoint.class);

    @Autowired
    private Tdatos_consultasRepository tdatos_consultasRepository;

    @Autowired
    private Tdatos_consultasServices tdatos_consultasServices;
}
