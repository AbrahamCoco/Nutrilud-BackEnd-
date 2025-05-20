package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TrolsDTO {
    private int id;
    private String rol;
    private int estado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
