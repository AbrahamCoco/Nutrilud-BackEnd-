package com.devconmx.nutrilud_backend.model.beans;

import lombok.Data;

@Data
public class AgendaBean {
  private int id_paciente;
  private String siguiente_consulta;
  private String nombre;
  private String primer_apellido;
  private String segundo_apellido;
}
