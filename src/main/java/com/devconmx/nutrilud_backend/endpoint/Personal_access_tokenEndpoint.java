package com.devconmx.nutrilud_backend.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.UsersVO;
import com.devconmx.nutrilud_backend.service.Personal_access_tokensServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("personal_access_token")
@RestController()
@CrossOrigin(origins = "*")
public class Personal_access_tokenEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(Personal_access_tokenEndpoint.class);

    @Autowired
    private Personal_access_tokensServices personal_access_tokenServices;

    @GetMapping("/get_secret_key")
    public ResponseEntity<ResponseBean<String>> getSecretKey() {
        ResponseEntity<ResponseBean<String>> response = null;
        LOG.info("Getting secret key");
        String secretKey = null;
        try {
            secretKey = personal_access_tokenServices.getSecretKey();
            response = Utils.response200OK("Secret key", secretKey);
        } catch (Exception e) {
            response = Utils.handle(e, "Error getting secret key");
        }
        LOG.info("Secret key: " + secretKey);
        return response;
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseBean<String>> login(@RequestParam String usuario, @RequestParam String contrasenia) {
        ResponseEntity<ResponseBean<String>> response = null;
        LOG.info("login() -> usuario: *********, contrasenia: *********");
        UsersVO vo = null;
        String token = null;
        try {
            vo = personal_access_tokenServices.login(usuario, contrasenia);
            token = personal_access_tokenServices.generateToken(vo);
            response = Utils.response200OK("Inicio de sesion exitoso", token);
        } catch (Exception e) {
            response = Utils.handle(e, "Error en inicio de sesion");
        }
        LOG.info("Token Generado");
        return response;
    }
}