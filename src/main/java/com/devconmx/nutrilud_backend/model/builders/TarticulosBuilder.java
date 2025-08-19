package com.devconmx.nutrilud_backend.model.builders;

import com.devconmx.nutrilud_backend.model.dtos.TarticulosDTO;
import com.devconmx.nutrilud_backend.model.vos.TarticulosVO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;

public class TarticulosBuilder {
    public static TarticulosDTO fromVO(TarticulosVO TarticulosVO) {
        TarticulosVO origin = TarticulosVO;
        TarticulosDTO destin = new TarticulosDTO();

        destin.setId(origin.getId());
        destin.setNutriologo_id(origin.getTusuario_nutriologo().getId());
        destin.setContenido(origin.getContenido());
        destin.setFoto(origin.getFoto());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static TarticulosVO fromDTO(TarticulosDTO TarticulosDTO) {
        TarticulosDTO origin = TarticulosDTO;
        TarticulosVO destin = new TarticulosVO();

        destin.setId(origin.getId());
        destin.setTusuario_nutriologo(new UsersVO());
        destin.setContenido(origin.getContenido());
        destin.setFoto(origin.getFoto());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
