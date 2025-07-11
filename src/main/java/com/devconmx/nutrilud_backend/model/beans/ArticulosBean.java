package com.devconmx.nutrilud_backend.model.beans;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticulosBean {
  private int id;
  private String contenido;
  private String foto;
  private String nameNutriologo;
  private LocalDateTime articulocreated;
}
