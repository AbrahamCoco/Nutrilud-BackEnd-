package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(TrolsEndpoint.class);

    @Autowired
    private TrolsRepository trolsRepository;

    @Autowired
    private TrolsServices trolsServices;
}
