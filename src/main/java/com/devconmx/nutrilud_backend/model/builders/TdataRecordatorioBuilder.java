package com.devconmx.nutrilud_backend.model.builders;

import com.devconmx.nutrilud_backend.model.dtos.TdataRecordatorioDTO;
import com.devconmx.nutrilud_backend.model.vos.T_recordatoriosVO;
import com.devconmx.nutrilud_backend.model.vos.TdataRecordatoriosVO;

public class TdataRecordatorioBuilder {
  public static TdataRecordatorioDTO fromVO(TdataRecordatoriosVO tdataRecordatoriosVO){
    TdataRecordatoriosVO origin = tdataRecordatoriosVO;
    TdataRecordatorioDTO destin = new TdataRecordatorioDTO();

    destin.setId(origin.getId());
    destin.setT_recordatorio_id(origin.getT_recordatorio().getId());
    destin.setComida(origin.getComida());
    destin.setHora(origin.getHora());
    destin.setLugar(origin.getLugar());
    destin.setAlimentos(origin.getAlimentos());
    destin.setPorciones(origin.getPorciones());
    destin.setMarca(origin.getMarca());
    destin.setPreparacion(origin.getPreparacion());
    destin.setCreated_at(origin.getCreated_at());
    destin.setUpdated_at(origin.getUpdated_at());

    return destin;
  }

  public static TdataRecordatoriosVO fromDTO(TdataRecordatorioDTO tdataRecordatorioDTO){
    TdataRecordatorioDTO origin = tdataRecordatorioDTO;
    TdataRecordatoriosVO destin = new TdataRecordatoriosVO();

    destin.setId(origin.getId());
    destin.setT_recordatorio(new T_recordatoriosVO());
    destin.setComida(origin.getComida());
    destin.setHora(origin.getHora());
    destin.setLugar(origin.getLugar());
    destin.setAlimentos(origin.getAlimentos());
    destin.setPorciones(origin.getPorciones());
    destin.setMarca(origin.getMarca());
    destin.setPreparacion(origin.getPreparacion());
    destin.setCreated_at(origin.getCreated_at());
    destin.setUpdated_at(origin.getUpdated_at());

    return destin;
  }
}
