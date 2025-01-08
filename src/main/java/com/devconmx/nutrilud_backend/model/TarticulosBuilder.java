package com.devconmx.nutrilud_backend.model;

public class TarticulosBuilder {
    public static TarticulosDTO fromVO(TarticulosVO TarticulosVO) {
        TarticulosVO origin = TarticulosVO;
        TarticulosDTO destin = new TarticulosDTO();

        destin.setId(origin.getId());

        destin.setNutriologo_id(origin.getTusuario_nutriologo().getId());
        destin.setNutriologo_nombre(origin.getTusuario_nutriologo().getNombre());
        destin.setNutriologo_primer_apellido(origin.getTusuario_nutriologo().getPrimer_apellido());
        destin.setNutriologo_segundo_apellido(origin.getTusuario_nutriologo().getSegundo_apellido());
        destin.setNutriologo_rol_id(origin.getTusuario_nutriologo().getTrols().getId());

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
