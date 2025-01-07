package com.devconmx.nutrilud_backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.UsersServices;

@RequestMapping("users")
@RestController()
@CrossOrigin(origins = "*")
public class UsersEndpoint {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersServices usersServices;
}
