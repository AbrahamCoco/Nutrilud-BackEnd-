package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.T_recordatoriosRepository;
import com.devconmx.nutrilud_backend.service.T_recordatoriosServices;

@RequestMapping("t_recordatorios")
@RestController()
@CrossOrigin(origins = "*")
public class T_recordatoriosEndpoint {
    @Autowired
    private T_recordatoriosRepository t_recordatoriosRepository;

    @Autowired
    private T_recordatoriosServices t_recordatoriosServices;
}
