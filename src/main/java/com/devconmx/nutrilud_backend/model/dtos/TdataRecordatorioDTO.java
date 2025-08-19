package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TdataRecordatorioDTO {
  private int id;
  private int t_recordatorio_id;
  private String comida;
  private String hora;
  private String lugar;
  private String alimentos;
  private String porciones;
  private String marca;
  private String preparacion;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
