package com.devconmx.nutrilud_backend.model.beans;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserBean {
  private int id;
  private String nombre;
  private String foto;
  private String correo;
  private String telefono;
  private String direccion;
  private int cedula;
  private String descripcion;
  private String especialidad;
  private String sexo;
  private String alergias;
  private double estatura;
  private double peso;
  private double imc;
  private LocalDateTime fechaNacimiento;
}
