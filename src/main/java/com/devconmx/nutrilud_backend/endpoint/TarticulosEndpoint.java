package com.devconmx.nutrilud_backend.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devconmx.nutrilud_backend.model.TarticulosVO;
import com.devconmx.nutrilud_backend.repository.TarticulosRepository;
import com.devconmx.nutrilud_backend.service.TarticulosServices;
import com.devconmx.nutrilud_backend.utils.ResponseBean;
import com.devconmx.nutrilud_backend.utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("tarticulos")
@RestController()
@CrossOrigin(origins = "*")
public class TarticulosEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(TarticulosEndpoint.class);

    @Autowired
    private TarticulosRepository tarticulosRepository;

    @Autowired
    private TarticulosServices tarticulosServices;

    @GetMapping("/findAllArticles")
    public ResponseEntity<ResponseBean<List<TarticulosVO>>> findAllArticles() {
        ResponseEntity<ResponseBean<List<TarticulosVO>>> response = null;
        List<TarticulosVO> articulosVO = null;
        try {
            articulosVO = tarticulosServices.findAll();
            response = Utils.response200OK("Articulos encontrados", articulosVO);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al obtener los articulos");
        }
        LOG.info("findAllArticles->response: {}", response);
        return response;
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseBean<List<TarticulosVO>>> findById(@RequestParam Long id) {
        ResponseEntity<ResponseBean<List<TarticulosVO>>> response = null;
        List<TarticulosVO> articulosVO = null;
        try {
            articulosVO = tarticulosServices.findById(id);
            response = Utils.response200OK("Articulos encontrados", articulosVO);
        } catch (Exception e) {
            response = Utils.handle(e, "Error al obtener los articulos");
        }
        LOG.info("findById->response: {}", response);
        return response;
    }
}
