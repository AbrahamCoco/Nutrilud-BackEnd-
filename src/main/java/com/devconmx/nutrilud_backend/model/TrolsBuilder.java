package com.devconmx.nutrilud_backend.model;

public class TrolsBuilder {
    public static TrolsDTO fromVO(TrolsVO TrolsVO) {
        TrolsVO origin = TrolsVO;
        TrolsDTO destin = new TrolsDTO();

        destin.setId(origin.getId());
        destin.setRol(origin.getRol());
        destin.setEstado(origin.getEstado());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static TrolsVO fromDTO(TrolsDTO TrolsDTO) {
        TrolsDTO origin = TrolsDTO;
        TrolsVO destin = new TrolsVO();

        destin.setId(origin.getId());
        destin.setRol(origin.getRol());
        destin.setEstado(origin.getEstado());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
