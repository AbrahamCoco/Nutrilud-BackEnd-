package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.Tusuario_nutriologosRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_nutriologosServices;

@RequestMapping("tusuario_nutriologos")
@RestController()
@CrossOrigin(origins = "*")
public class Tusuario_nutriologosEndpoint {
    @Autowired
    private Tusuario_nutriologosRepository tusuario_nutriologosRepository;

    @Autowired
    private Tusuario_nutriologosServices tusuario_nutriologosServices;
}
