package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class T_recordatoriosDTO {
    private int id;
    private int nutriologo_id;
    private int paciente_id;
    private String otros;
    private String observaciones;
    private TdataRecordatorioListDTO tdata_recordatorio;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
