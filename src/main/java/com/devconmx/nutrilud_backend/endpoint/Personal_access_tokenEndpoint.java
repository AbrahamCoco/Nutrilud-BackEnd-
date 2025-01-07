package com.devconmx.nutrilud_backend.endpoint;

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
    @Autowired
    private Personal_access_tokensRepository personal_access_tokenRepository;

    @Autowired
    private Personal_access_tokensServices personal_access_tokenServices;
}
