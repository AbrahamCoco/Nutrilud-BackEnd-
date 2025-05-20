package com.devconmx.nutrilud_backend.model.builders;

import com.devconmx.nutrilud_backend.model.dtos.Personal_access_tokenDTO;
import com.devconmx.nutrilud_backend.model.vos.Personal_access_tokenVO;

public class Personal_access_tokenBuilder {
    public static Personal_access_tokenDTO fromVO(Personal_access_tokenVO Personal_access_tokenVO) {
        Personal_access_tokenVO origin = Personal_access_tokenVO;
        Personal_access_tokenDTO destin = new Personal_access_tokenDTO();

        destin.setId(origin.getId());
        destin.setTokenable_type(origin.getTokenable_type());
        destin.setTokenable_id(origin.getTokenable_id());
        destin.setName(origin.getName());
        destin.setToken(origin.getToken());
        destin.setAbilities(origin.getAbilities());
        destin.setLast_used_at(origin.getLast_used_at());
        destin.setExpires_at(origin.getExpires_at());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }

    public static Personal_access_tokenVO fromDTO(Personal_access_tokenDTO Personal_access_tokenDTO) {
        Personal_access_tokenDTO origin = Personal_access_tokenDTO;
        Personal_access_tokenVO destin = new Personal_access_tokenVO();

        destin.setId(origin.getId());
        destin.setTokenable_type(origin.getTokenable_type());
        destin.setTokenable_id(origin.getTokenable_id());
        destin.setName(origin.getName());
        destin.setToken(origin.getToken());
        destin.setAbilities(origin.getAbilities());
        destin.setLast_used_at(origin.getLast_used_at());
        destin.setExpires_at(origin.getExpires_at());
        destin.setCreated_at(origin.getCreated_at());
        destin.setUpdated_at(origin.getUpdated_at());

        return destin;
    }
}
