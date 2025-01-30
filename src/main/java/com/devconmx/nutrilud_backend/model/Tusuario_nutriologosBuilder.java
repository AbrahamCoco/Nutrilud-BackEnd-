package com.devconmx.nutrilud_backend.model;

public class Tusuario_nutriologosBuilder {
    public static Tusuario_nutriologosDTO fromVO(Tusuario_nutriologosVO Tusuario_nutriologosVO) {
        Tusuario_nutriologosVO origin = Tusuario_nutriologosVO;
        Tusuario_nutriologosDTO destin = new Tusuario_nutriologosDTO();

        destin.setId(origin.getId());
        destin.setDescripcion(origin.getDescripcion());
        destin.setFoto(origin.getFoto());
        destin.setDireccion(origin.getDireccion());
        destin.setTelefono(origin.getTelefono());
        destin.setCedula_profesional(origin.getCedula_profesional());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static Tusuario_nutriologosVO fromDTO(Tusuario_nutriologosDTO Tusuario_nutriologosDTO) {
        Tusuario_nutriologosDTO origin = Tusuario_nutriologosDTO;
        Tusuario_nutriologosVO destin = new Tusuario_nutriologosVO();

        destin.setId(origin.getId());
        destin.setDescripcion(origin.getDescripcion());
        destin.setFoto(origin.getFoto());
        destin.setDireccion(origin.getDireccion());
        destin.setTelefono(origin.getTelefono());
        destin.setCedula_profesional(origin.getCedula_profesional());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
