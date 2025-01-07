package com.devconmx.nutrilud_backend.model;

public class Tdatos_consultasBuilder {
    public static Tdatos_consultasDTO fromVO(Tdatos_consultasVO Tdatos_consultasVO) {
        Tdatos_consultasVO origin = Tdatos_consultasVO;
        Tdatos_consultasDTO destin = new Tdatos_consultasDTO();

        destin.setId(origin.getId());
        destin.setNutriologo_id(origin.getNutriologo_id());
        destin.setPaciente_id(origin.getPaciente_id());
        destin.setPeso(origin.getPeso());
        destin.setEstatura(origin.getEstatura());
        destin.setPorcentaje_grasa(origin.getPorcentaje_grasa());
        destin.setPorcentaje_musculo(origin.getPorcentaje_musculo());
        destin.setImc(origin.getImc());
        destin.setCircunferencia_cintura(origin.getCircunferencia_cintura());
        destin.setCircunferencia_cadera(origin.getCircunferencia_cadera());
        destin.setCircunferencia_brazo(origin.getCircunferencia_brazo());
        destin.setPliegue_bicipital(origin.getPliegue_bicipital());
        destin.setPliegue_tricipital(origin.getPliegue_tricipital());
        destin.setFecha_medicion(origin.getFecha_medicion());
        destin.setSiguiente_consulta(origin.getSiguiente_consulta());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static Tdatos_consultasVO fromDTO(Tdatos_consultasDTO Tdatos_consultasDTO) {
        Tdatos_consultasDTO origin = Tdatos_consultasDTO;
        Tdatos_consultasVO destin = new Tdatos_consultasVO();

        destin.setId(origin.getId());
        destin.setNutriologo_id(origin.getNutriologo_id());
        destin.setPaciente_id(origin.getPaciente_id());
        destin.setPeso(origin.getPeso());
        destin.setEstatura(origin.getEstatura());
        destin.setPorcentaje_grasa(origin.getPorcentaje_grasa());
        destin.setPorcentaje_musculo(origin.getPorcentaje_musculo());
        destin.setImc(origin.getImc());
        destin.setCircunferencia_cintura(origin.getCircunferencia_cintura());
        destin.setCircunferencia_cadera(origin.getCircunferencia_cadera());
        destin.setCircunferencia_brazo(origin.getCircunferencia_brazo());
        destin.setPliegue_bicipital(origin.getPliegue_bicipital());
        destin.setPliegue_tricipital(origin.getPliegue_tricipital());
        destin.setFecha_medicion(origin.getFecha_medicion());
        destin.setSiguiente_consulta(origin.getSiguiente_consulta());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
