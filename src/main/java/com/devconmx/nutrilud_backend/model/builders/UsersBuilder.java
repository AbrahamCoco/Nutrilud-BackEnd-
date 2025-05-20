package com.devconmx.nutrilud_backend.model.builders;

import com.devconmx.nutrilud_backend.model.dtos.UsersDTO;
import com.devconmx.nutrilud_backend.model.vos.UsersVO;

public class UsersBuilder {
    public static UsersDTO fromVO(UsersVO UsersVO) {
        UsersVO origin = UsersVO;
        UsersDTO destin = new UsersDTO();

        destin.setId(origin.getId());
        destin.setRol_id(origin.getTrols().getId());
        destin.setTusuario_admin_id(origin.getTusuario_admins().getId());
        destin.setTusuario_nutriologo_id(origin.getTusuario_nutriologos().getId());
        destin.setTusuario_paciente_id(origin.getTusuario_pacientes().getId());
        destin.setNombre(origin.getNombre());
        destin.setPrimer_apellido(origin.getPrimer_apellido());
        destin.setSegundo_apellido(origin.getSegundo_apellido());
        destin.setUsuario(origin.getUsuario());
        destin.setCorreo(origin.getCorreo());
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
        destin.setNombre(origin.getNombre());
        destin.setPrimer_apellido(origin.getPrimer_apellido());
        destin.setSegundo_apellido(origin.getSegundo_apellido());
        destin.setUsuario(origin.getUsuario());
        destin.setCorreo(origin.getCorreo());
        destin.setContrasenia(origin.getContrasenia());
        destin.setEstado(origin.getEstado());
        destin.setRemember_token(origin.getRemember_token());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
