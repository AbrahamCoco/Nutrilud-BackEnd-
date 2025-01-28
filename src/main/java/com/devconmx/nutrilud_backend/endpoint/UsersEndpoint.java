package com.devconmx.nutrilud_backend.endpoint;

import java.util.List;

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
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("users")
@RestController()
@CrossOrigin(origins = "*")
public class UsersEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(UsersEndpoint.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersServices usersServices;

    @GetMapping("/findAllPacientes")
    public ResponseEntity<ResponseBean<List<UsersVO>>> findAllPacientes() {
        ResponseEntity<ResponseBean<List<UsersVO>>> response = null;
        LOG.info("findAllPacientes()");
        List<UsersVO> vo = null;
        try {
            vo = usersRepository.findByPaciente();
            response = Utils.response200OK("Pacientes encontrados", vo);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar pacientes");
        }
        LOG.info("findAllPacientes() response: {}", response);
        return response;
    }

    @GetMapping("/findByIdPaciente")
    public ResponseEntity<ResponseBean<UsersVO>> findByIdPaciente(@RequestParam int id) {
        ResponseEntity<ResponseBean<UsersVO>> response = null;
        LOG.info("findByIdPaciente() -> id: {}", id);
        UsersVO vo = null;
        try {
            vo = usersRepository.findByIdPaciente(id);
            response = Utils.response200OK("Paciente encontrado", vo);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar paciente");
        }
        LOG.info("findByIdPaciente() response: {}", response);
        return response;
    }

    @GetMapping("/deleteByIdPaciente")
    public ResponseEntity<ResponseBean<Void>> deleteByIdPaciente(@RequestParam int id) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("deleteByIdPaciente() -> id: {}", id);
        try {
            usersServices.deleteByIdPaciente(id);
            response = Utils.response200OK("Paciente eliminado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al eliminar paciente");
        }
        LOG.info("deleteByIdPaciente() response: {}", response);
        return response;
    }
}
