package com.devconmx.nutrilud_backend.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devconmx.nutrilud_backend.model.beans.ArticulosBean;
import com.devconmx.nutrilud_backend.model.builders.TarticulosBuilder;
import com.devconmx.nutrilud_backend.model.dtos.TarticulosDTO;
import com.devconmx.nutrilud_backend.model.vos.TarticulosVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;
import com.devconmx.nutrilud_backend.repository.TarticulosRepository;
import com.devconmx.nutrilud_backend.repository.UsersRepository;
import com.devconmx.nutrilud_backend.service.TarticulosServices;
import com.devconmx.nutrilud_backend.utils.Utils;
import com.devconmx.nutrilud_backend.utils.exception.AppException;

@Service
public class TarticulosServiceImpl implements TarticulosServices {
    private static final Logger LOG = LoggerFactory.getLogger(TarticulosServices.class);

    @Autowired
    private TarticulosRepository tarticulosRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<ArticulosBean> findAll() throws AppException {
        LOG.info("FindAllArticulosService() -> Articulos");
        List<TarticulosVO> listTarticulosVOs = null;
        List<ArticulosBean> articulosBeans = new ArrayList<>();
        try {
            listTarticulosVOs = tarticulosRepository.findAll();
            listTarticulosVOs.forEach(articulo -> {
                ArticulosBean bean = new ArticulosBean();
                bean.setId(articulo.getId());
                bean.setContenido(articulo.getContenido());
                bean.setFoto(articulo.getFoto());
                bean.setNameNutriologo(articulo.getTusuario_nutriologo().getNombre() + " " + articulo.getTusuario_nutriologo().getPrimer_apellido() + " " + articulo.getTusuario_nutriologo().getSegundo_apellido());
                bean.setArticulocreated(articulo.getCreated_at());
                articulosBeans.add(bean);
            });
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        LOG.info("FindAllArticulosService() -> Articulos cargados correctamente");
        return articulosBeans;
    }

    @Override
    public ArticulosBean findById(int id) throws AppException {
        LOG.info("FindByIdArticulosService() -> Articulos");
        TarticulosVO listTarticulosVOs = null;
        ArticulosBean articulo = null;
        try {
            listTarticulosVOs = tarticulosRepository.findById(id);
            if (listTarticulosVOs != null) {
                articulo = new ArticulosBean();
                articulo.setId(listTarticulosVOs.getId());
                articulo.setContenido(listTarticulosVOs.getContenido());
                articulo.setFoto(listTarticulosVOs.getFoto());
                articulo.setNameNutriologo(listTarticulosVOs.getTusuario_nutriologo().getNombre() + " " + listTarticulosVOs.getTusuario_nutriologo().getPrimer_apellido() + " " + listTarticulosVOs.getTusuario_nutriologo().getSegundo_apellido());
                articulo.setArticulocreated(listTarticulosVOs.getCreated_at());
            }
        } catch (Exception e) {
            Utils.raise(e, "Error al obtener los articulos");
        }
        LOG.info("FindByIdArticulosService() -> Articulo cargado correctamente");
        return articulo;
    }

    @Override
    public void save(TarticulosDTO tarticulosDTO) throws AppException {
        LOG.info("insertArticuloService() -> TarticulosVO: {}", tarticulosDTO);
        TarticulosVO vo = null;
        try {
            vo = TarticulosBuilder.fromDTO(tarticulosDTO);
            vo.setCreated_at(LocalDateTime.now());
            vo.setUpdated_at(LocalDateTime.now());
            UsersVO user = usersRepository.findByNutriologo(tarticulosDTO.getNutriologo_id());
            vo.setTusuario_nutriologo(user);
            tarticulosRepository.save(vo);
        } catch (Exception e) {
            Utils.raise(e, "Error al insertar el articulo");
        }
    }
}
