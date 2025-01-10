package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

public class Tusuario_adminsDTO {
    private Long id;
    private String descripcion;
    private String foto;
    private String telefono;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Tusuario_adminsDTO() {
    }

    public Tusuario_adminsDTO(Long id, String descripcion, String foto, String telefono, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.foto = foto;
        this.telefono = telefono;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
