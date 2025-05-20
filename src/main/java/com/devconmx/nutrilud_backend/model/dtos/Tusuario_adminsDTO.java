package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Tusuario_adminsDTO {
    private int id;
    private String descripcion;
    private String foto;
    private String telefono;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
