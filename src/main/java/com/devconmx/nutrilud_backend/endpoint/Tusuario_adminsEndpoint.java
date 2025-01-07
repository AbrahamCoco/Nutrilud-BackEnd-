package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.Tusuario_adminsRepository;
import com.devconmx.nutrilud_backend.service.Tusuario_adminsServices;

@RequestMapping("tusuario_admins")
@RestController
@CrossOrigin(origins = "*")
public class Tusuario_adminsEndpoint {
    @Autowired
    private Tusuario_adminsRepository tusuario_adminsRepository;

    @Autowired
    private Tusuario_adminsServices tusuario_adminsServices;
}
