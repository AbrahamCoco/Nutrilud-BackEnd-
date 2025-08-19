package com.devconmx.nutrilud_backend.model.builders;

import com.devconmx.nutrilud_backend.model.dtos.Tusuario_pacientesDTO;
import com.devconmx.nutrilud_backend.model.vos.Tusuario_pacientesVO;

public class Tusuario_pacientesBuilder {
    public static Tusuario_pacientesDTO fromVO(Tusuario_pacientesVO Tusuario_pacientesVO) {
        Tusuario_pacientesVO origin = Tusuario_pacientesVO;
        Tusuario_pacientesDTO destin = new Tusuario_pacientesDTO();

        destin.setId(origin.getId());
        destin.setFoto(origin.getFoto());
        destin.setTelefono(origin.getTelefono());
        destin.setFecha_nacimiento(origin.getFecha_nacimiento());
        destin.setSexo(origin.getSexo());
        destin.setAlergias(origin.getAlergias());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static Tusuario_pacientesVO fromDTO(Tusuario_pacientesDTO Tusuario_pacientesDTO) {
        Tusuario_pacientesDTO origin = Tusuario_pacientesDTO;
        Tusuario_pacientesVO destin = new Tusuario_pacientesVO();

        destin.setId(origin.getId());
        destin.setFoto(origin.getFoto());
        destin.setTelefono(origin.getTelefono());
        destin.setFecha_nacimiento(origin.getFecha_nacimiento());
        destin.setSexo(origin.getSexo());
        destin.setAlergias(origin.getAlergias());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
