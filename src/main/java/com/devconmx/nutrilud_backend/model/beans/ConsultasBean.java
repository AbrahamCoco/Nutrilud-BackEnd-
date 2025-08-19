package com.devconmx.nutrilud_backend.model.beans;

import lombok.Data;

@Data
public class ConsultasBean {
  private int id;
  private double peso;
  private double estatura;
  private double porcentaje_grasa;
  private double porcentaje_musculo;
  private double imc;
  private double circunferencia_cintura;
  private double circunferencia_cadera;
  private double circunferencia_brazo;
  private double pliegue_bicipital;
  private double pliegue_tricipital;
  private double glucosa;
  private double colesterol;
  private double trigliceridos;
  private String presion_arterial;
  private String fecha_medicion;
}
