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

import com.devconmx.nutrilud_backend.model.beans.ArticulosBean;
import com.devconmx.nutrilud_backend.model.dtos.TarticulosDTO;
import com.devconmx.nutrilud_backend.service.TarticulosServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

@RequestMapping("tarticulos")
@RestController()
@CrossOrigin(origins = "*")
public class TarticulosEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(TarticulosEndpoint.class);

    @Autowired
    private TarticulosServices tarticulosServices;

    @GetMapping("/findAllArticles")
    public ResponseEntity<ResponseBean<List<ArticulosBean>>> findAllArticles() {
        ResponseEntity<ResponseBean<List<ArticulosBean>>> response = null;
        LOG.info("findAllArticlesEndpoint()");
        List<ArticulosBean> articulos = null;
        try {
            articulos = tarticulosServices.findAll();
            response = Utils.response200OK("Articulos encontrados", articulos);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al obtener los articulos");
        }
        LOG.info("findAllArticlesEndpoint() -> response: {}", response);
        return response;
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseBean<ArticulosBean>> findById(@RequestParam int id) {
        ResponseEntity<ResponseBean<ArticulosBean>> response = null;
        LOG.info("findByIdArticuloEndpoint() -> id: {}", id);
        ArticulosBean articulos = null;
        try {
            articulos = tarticulosServices.findById(id);
            response = Utils.response200OK("Articulos encontrados", articulos);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al obtener los articulos");
        }
        LOG.info("findByIdArticuloEndpoint() -> response: {}", response);
        return response;
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseBean<Void>> insert(@RequestBody TarticulosDTO tarticulosDTO) {
        ResponseEntity<ResponseBean<Void>> response = null;
        LOG.info("insertArticuloEndpoint() -> TarticulosDTO: {}", tarticulosDTO);
        try {
            tarticulosServices.save(tarticulosDTO);
            response = Utils.response200OK("Articulo guardado correctamente");
        } catch (Exception e) {
            response = Utils.handle(e, "Error al guardar el articulo");
        }
        LOG.info("insertArticuloEndpoint() -> response: {}", response);
        return response;
    }
}
