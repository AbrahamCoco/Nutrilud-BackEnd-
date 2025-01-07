package com.devconmx.nutrilud_backend.model;

public class UsersBuilder {
    public static UsersDTO fromVO(UsersVO UsersVO) {
        UsersVO origin = UsersVO;
        UsersDTO destin = new UsersDTO();

        destin.setId(origin.getId());
        destin.setRol_id(origin.getTrol_id());
        destin.setTusuario_admin_id(origin.getTusuario_admin_id());
        destin.setTusuario_nutriologo_id(origin.getTusuario_nutriologo_id());
        destin.setTusuario_paciente_id(origin.getTusuario_paciente_id());
        destin.setNombre(origin.getNombre());
        destin.setPrimer_apellido(origin.getPrimer_apellido());
        destin.setSegundo_apellido(origin.getSegundo_apellido());
        destin.setUsuario(origin.getUsuario());
        destin.setContrasenia(origin.getContrasenia());
        destin.setEstado(origin.getEstado());
        destin.setRemember_token(origin.getRemember_token());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static UsersVO fromDTO(UsersDTO UsersDTO) {
        UsersDTO origin = UsersDTO;
        UsersVO destin = new UsersVO();

        destin.setId(origin.getId());
        destin.setTrol_id(origin.getRol_id());
        destin.setTusuario_admin_id(origin.getTusuario_admin_id());
        destin.setTusuario_nutriologo_id(origin.getTusuario_nutriologo_id());
        destin.setTusuario_paciente_id(origin.getTusuario_paciente_id());
        destin.setNombre(origin.getNombre());
        destin.setPrimer_apellido(origin.getPrimer_apellido());
        destin.setSegundo_apellido(origin.getSegundo_apellido());
        destin.setUsuario(origin.getUsuario());
        destin.setContrasenia(origin.getContrasenia());
        destin.setEstado(origin.getEstado());
        destin.setRemember_token(origin.getRemember_token());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
