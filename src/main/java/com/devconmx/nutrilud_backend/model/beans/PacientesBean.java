package com.devconmx.nutrilud_backend.model.beans;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PacientesBean {
  private int id;
  private int id_paciente;
  private String nombrePaciente;
  private String sexo;
  private String correo;
  private String telefono;
  private String usuario;
  private LocalDateTime fechaNacimiento;
  private String alergias;
}
