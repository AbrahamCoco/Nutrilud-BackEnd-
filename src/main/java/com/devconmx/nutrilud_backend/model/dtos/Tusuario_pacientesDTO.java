package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Tusuario_pacientesDTO {
    private int id;
    private String foto;
    private String telefono;
    private LocalDateTime fecha_nacimiento;
    private String sexo;
    private String alergias;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
