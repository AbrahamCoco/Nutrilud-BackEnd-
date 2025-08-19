package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Tusuario_nutriologosDTO {
    private int id;
    private String descripcion;
    private String foto;
    private String direccion;
    private String telefono;
    private int cedula_profesional;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
