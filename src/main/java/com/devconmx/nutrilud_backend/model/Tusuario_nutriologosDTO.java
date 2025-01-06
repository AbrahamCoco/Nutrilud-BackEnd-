package com.devconmx.nutrilud_backend.model;

public class Tusuario_nutriologosDTO {
    private Integer id;
    private String descripcion;
    private String foto;
    private String direccion;
    private String telefono;
    private Integer cedula_profesional;
    private String created_at;
    private String updated_at;

    public Tusuario_nutriologosDTO() {
    }

    public Tusuario_nutriologosDTO(Integer id, String descripcion, String foto, String direccion, String telefono,
            Integer cedula_profesional, String created_at, String updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.foto = foto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cedula_profesional = cedula_profesional;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCedula_profesional() {
        return cedula_profesional;
    }

    public void setCedula_profesional(Integer cedula_profesional) {
        this.cedula_profesional = cedula_profesional;
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
