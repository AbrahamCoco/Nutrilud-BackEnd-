package com.devconmx.nutrilud_backend.model;

public class Tusuario_adminsBuilder {
    public static Tusuario_adminsDTO fromVO(Tusuario_adminsVO Tusuario_adminsVO) {
        Tusuario_adminsVO origin = Tusuario_adminsVO;
        Tusuario_adminsDTO destin = new Tusuario_adminsDTO();

        destin.setId(origin.getId());
        destin.setDescripcion(origin.getDescripcion());
        destin.setFoto(origin.getFoto());
        destin.setTelefono(origin.getTelefono());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static Tusuario_adminsVO fromDTO(Tusuario_adminsDTO Tusuario_adminsDTO) {
        Tusuario_adminsDTO origin = Tusuario_adminsDTO;
        Tusuario_adminsVO destin = new Tusuario_adminsVO();

        destin.setId(origin.getId());
        destin.setDescripcion(origin.getDescripcion());
        destin.setFoto(origin.getFoto());
        destin.setTelefono(origin.getTelefono());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
