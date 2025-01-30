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

import com.devconmx.nutrilud_backend.model.TrolsDTO;
import com.devconmx.nutrilud_backend.model.TrolsVO;
import com.devconmx.nutrilud_backend.service.TrolsServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("trols")
@RestController()
@CrossOrigin(origins = "*")
public class TrolsEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(TrolsEndpoint.class);

    @Autowired
    private TrolsServices trolsServices;

    @PostMapping("/insert")
    public ResponseEntity<ResponseBean<Void>> insert(@RequestBody TrolsDTO trolsDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("insertTrolsEndpoint() -> Trols: {}", trolsDTO);
        try {
            trolsServices.save(trolsDTO);
            response = Utils.response200OK("Rol insertado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al insertar el rol");
        }
        LOG.info("insertTrolsEndpoint() -> response: {}", response);
        return response;
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseBean<Void>> update(@RequestParam int id, @RequestBody TrolsDTO trolsDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("updateTrolsEndpoint() -> id: {}, Trols: {}", id, trolsDTO);
        try {
            trolsServices.update(id, trolsDTO);
            response = Utils.response200OK("Rol actualizado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al actualizar el rol");
        }
        LOG.info("updateTrolsEndpoint() -> response: {}", response);
        return response;
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseBean<Void>> delete(@RequestParam int id) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("deleteTrolsEndpoint() -> id: {}", id);
        try {
            trolsServices.delete(id);
            response = Utils.response200OK("Rol eliminado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al eliminar el rol");
        }
        LOG.info("deleteTrolsEndpoint() -> response: {}", response);
        return response;
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseBean<TrolsVO>> findById(@RequestParam int id) {
        ResponseEntity<ResponseBean<TrolsVO>> response = null;
        LOG.info("findByIdTrolsEndpoint() -> id: {}", id);
        TrolsVO trolVO = null;
        try {
            trolVO = trolsServices.findById(id);
            response = Utils.response200OK(trolVO);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar el rol");
        }
        LOG.info("findByIdTrolsEndpoint() -> response: {}", response);
        return response;
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseBean<List<TrolsVO>>> findAll() {
        ResponseEntity<ResponseBean<List<TrolsVO>>> response = null;
        LOG.info("findAllTrolsEndpoint()");
        List<TrolsVO> trolsVO = null;
        try {
            trolsVO = trolsServices.findAll();
            response = Utils.response200OK(trolsVO);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al buscar los roles");
        }
        LOG.info("findAllTrolsEndpoint() -> response: {}", response);
        return response;
    }
}
