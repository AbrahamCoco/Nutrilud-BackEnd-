package com.devconmx.nutrilud_backend.model.beans;

import lombok.Data;

@Data
public class PacientesBean {
  private int id;
  private int id_paciente;
  private String nombrePaciente;
  private String sexo;
  private String correo;
  private String telefono;
}
