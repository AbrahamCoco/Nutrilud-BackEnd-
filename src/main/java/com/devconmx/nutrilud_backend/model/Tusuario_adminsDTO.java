package com.devconmx.nutrilud_backend.model;

public class Tusuario_adminsDTO {
    private Integer id;
    private String descripcion;
    private String foto;
    private String telefono;
    private String created_at;
    private String updated_at;

    public Tusuario_adminsDTO() {
    }

    public Tusuario_adminsDTO(Integer id, String descripcion, String foto, String telefono, String created_at,
            String updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.foto = foto;
        this.telefono = telefono;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
