package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.TrolsRepository;
import com.devconmx.nutrilud_backend.service.TrolsServices;

@RequestMapping("trols")
@RestController()
@CrossOrigin(origins = "*")
public class TrolsEndpoint {
    @Autowired
    private TrolsRepository trolsRepository;

    @Autowired
    private TrolsServices trolsServices;
}
