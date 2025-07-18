package com.devconmx.nutrilud_backend.model.beans;

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
}
