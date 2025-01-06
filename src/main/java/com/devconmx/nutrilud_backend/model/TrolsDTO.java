package com.devconmx.nutrilud_backend.model;

public class TrolsDTO {
    private Integer id;
    private String rol;
    private Integer estado;
    private String created_at;
    private String updated_at;

    public TrolsDTO() {
    }

    public TrolsDTO(Integer id, String rol, Integer estado, String created_at, String updated_at) {
        this.id = id;
        this.rol = rol;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
