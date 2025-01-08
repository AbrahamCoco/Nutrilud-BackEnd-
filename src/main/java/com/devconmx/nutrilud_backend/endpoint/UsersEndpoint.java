package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.UsersDTO;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("users")
@RestController()
@CrossOrigin(origins = "*")
public class UsersEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(UsersEndpoint.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersServices usersServices;

    @PostMapping("/login")
    public ResponseEntity<ResponseBean<Void>> login(@RequestBody UsersDTO usersDTO) {
        ResponseEntity<ResponseBean<Void>> res = null;
        try {
            if (usersServices.verifyUser(usersDTO)) {
                res = Utils.<Void>response200OK(true, "Usuario verificado");
            } else {
                res = Utils.<Void>response200OK(false, "Usuario no verificado");
            }
        } catch (Exception e) {
            LOG.error("Error en login", e);
            res = Utils.<Void>handle(e, "Error en login");
        }
        return res;
    }
}
