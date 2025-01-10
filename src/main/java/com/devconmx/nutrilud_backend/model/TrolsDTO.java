package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

public class TrolsDTO {
    private Long id;
    private String rol;
    private Long estado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public TrolsDTO() {
    }

    public TrolsDTO(Long id, String rol, Long estado, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.rol = rol;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
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
