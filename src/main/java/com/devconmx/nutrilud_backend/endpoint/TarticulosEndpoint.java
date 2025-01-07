package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.TarticulosRepository;
import com.devconmx.nutrilud_backend.service.TarticulosServices;

@RequestMapping("tarticulos")
@RestController()
@CrossOrigin(origins = "*")
public class TarticulosEndpoint {
    @Autowired
    private TarticulosRepository tarticulosRepository;

    @Autowired
    private TarticulosServices tarticulosServices;
}
