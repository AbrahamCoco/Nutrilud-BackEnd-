package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TarticulosDTO {
    private int id;
    private int nutriologo_id;
    private String contenido;
    private String foto;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
