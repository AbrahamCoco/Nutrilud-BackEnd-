package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

public class TarticulosDTO {
    private Long id;
    private Long nutriologo_id;
    private String contenido;
    private String foto;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public TarticulosDTO() {
    }

    public TarticulosDTO(Long id, Long nutriologo_id, String contenido, String foto, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.nutriologo_id = nutriologo_id;
        this.contenido = contenido;
        this.foto = foto;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNutriologo_id() {
        return nutriologo_id;
    }

    public void setNutriologo_id(Long nutriologo_id) {
        this.nutriologo_id = nutriologo_id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
