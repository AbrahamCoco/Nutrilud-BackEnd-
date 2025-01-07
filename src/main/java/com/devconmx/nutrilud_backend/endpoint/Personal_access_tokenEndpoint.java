package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.Personal_access_tokensRepository;
import com.devconmx.nutrilud_backend.service.Personal_access_tokensServices;

@RequestMapping("personal_access_token")
@RestController()
@CrossOrigin(origins = "*")
public class Personal_access_tokenEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(Personal_access_tokenEndpoint.class);

    @Autowired
    private Personal_access_tokensRepository personal_access_tokenRepository;

    @Autowired
    private Personal_access_tokensServices personal_access_tokenServices;
}
