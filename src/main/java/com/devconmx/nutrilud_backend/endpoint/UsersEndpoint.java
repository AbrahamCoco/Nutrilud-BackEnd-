package com.devconmx.nutrilud_backend.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.beans.PacientesBean;
import com.devconmx.nutrilud_backend.model.beans.UserBean;
import com.devconmx.nutrilud_backend.model.dtos.UsersDTO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.service.UsersServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("users")
@RestController()
@CrossOrigin(origins = "*")
public class UsersEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(UsersEndpoint.class);

    @Autowired
    private UsersServices usersServices;

    @GetMapping("/findAllPacientes")
    public ResponseEntity<ResponseBean<List<PacientesBean>>> findAllPacientes() {
        ResponseEntity<ResponseBean<List<PacientesBean>>> response = null;
        LOG.info("findAllPacientes()");
        List<PacientesBean> vo = null;
        try {
            vo = usersServices.findAllPacientes();
            response = Utils.response200OK("Pacientes encontrados", vo);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar pacientes");
        }
        LOG.info("findAllPacientes() response: {}", response);
        return response;
    }

    @GetMapping("/findByIdPaciente")
    public ResponseEntity<ResponseBean<PacientesBean>> findByIdPaciente(@RequestParam int id) {
        ResponseEntity<ResponseBean<PacientesBean>> response = null;
        LOG.info("findByIdPaciente() -> id: {}", id);
        PacientesBean vo = null;
        try {
            vo = usersServices.findByIdPaciente(id);
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

    @PostMapping("/insert")
    public ResponseEntity<ResponseBean<Void>> insert(@RequestBody UsersDTO usersDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("insertUserEndpoint() -> UsersDTO: {}", usersDTO);
        try {
            usersServices.insert(usersDTO);
            response = Utils.response200OK("Usuario guardado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al guardar el usuario");
        }
        LOG.info("insertUserEndpoint() response: {}", response);
        return response;
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseBean<UserBean>> findById(@RequestParam int id) {
        ResponseEntity<ResponseBean<UserBean>> response = null;
        LOG.info("findByIdEndpoint() -> id: {}", id);
        UserBean vo = null;
        try {
            vo = usersServices.findById(id);
            response = Utils.response200OK("Usuario encontrado", vo);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar usuario");
        }
        LOG.info("findByIdEndpoint() response: {}", response);
        return response;
    }

    @GetMapping("/findAllAdminsAndNutris")
    public ResponseEntity<ResponseBean<List<UsersVO>>> findAllAdminsAndNutris() {
        ResponseEntity<ResponseBean<List<UsersVO>>> response = null;
        LOG.info("findAllAdminsAndNutrisEndpoint()");
        List<UsersVO> vo = null;
        try {
            vo = usersServices.findAllAdminsAndNutris();
            response = Utils.response200OK("Usuarios encontrados", vo);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar usuarios");
        }
        LOG.info("findAllAdminsAndNutrisEndpoint() response: {}", response);
        return response;
    }

    @PostMapping("/updatePaciente")
    public ResponseEntity<ResponseBean<Void>> updatePaciente(@RequestParam int id, @RequestBody UsersDTO usersDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("updatePaciente() -> id: {}, UsersDTO: {}", id, usersDTO);
        try {
            usersServices.updatePaciente(id, usersDTO);
            response = Utils.response200OK("Paciente actualizado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al actualizar el paciente");
        }
        LOG.info("updatePaciente() response: {}", response);
        return response;
    }
    
}
