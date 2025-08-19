package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TdataRecordatorioListDTO {
  private List<Integer> id;
  private List<String> comida;
  private List<String> hora;
  private List<String> lugar;
  private List<String> alimentos;
  private List<String> porciones;
  private List<String> marca;
  private List<String> preparacion;
  private List<LocalDateTime> created_at;
  private List<LocalDateTime> updated_at;
}
