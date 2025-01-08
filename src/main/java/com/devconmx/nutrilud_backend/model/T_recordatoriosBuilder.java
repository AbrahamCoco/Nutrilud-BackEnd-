package com.devconmx.nutrilud_backend.model;

public class T_recordatoriosBuilder {
    public static T_recordatoriosDTO fromVO(T_recordatoriosVO T_recordatoriosVO) {
        T_recordatoriosVO origin = T_recordatoriosVO;
        T_recordatoriosDTO destin = new T_recordatoriosDTO();

        destin.setId(origin.getId());
        destin.setNutriologo_id(origin.getTusuario_nutriologo().getId());
        destin.setPaciente_id(origin.getTusuario_paciente().getId());
        destin.setRecordatorioPdf(origin.getRecordatorioPdf());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static T_recordatoriosVO fromDTO(T_recordatoriosDTO T_recordatoriosDTO) {
        T_recordatoriosDTO origin = T_recordatoriosDTO;
        T_recordatoriosVO destin = new T_recordatoriosVO();

        destin.setId(origin.getId());
        destin.setTusuario_nutriologo(new UsersVO());
        destin.setTusuario_paciente(new UsersVO());
        destin.setRecordatorioPdf(origin.getRecordatorioPdf());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
