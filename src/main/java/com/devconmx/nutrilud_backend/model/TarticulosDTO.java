package com.devconmx.nutrilud_backend.model;

public class TarticulosDTO {
    private Integer id;
    private Integer nutriologo_id;
    private String contenido;
    private String foto;
    private String created_at;
    private String updated_at;

    public TarticulosDTO() {
    }

    public TarticulosDTO(Integer id, Integer nutriologo_id, String contenido, String foto, String created_at,
            String updated_at) {
        this.id = id;
        this.nutriologo_id = nutriologo_id;
        this.contenido = contenido;
        this.foto = foto;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNutriologo_id() {
        return nutriologo_id;
    }

    public void setNutriologo_id(Integer nutriologo_id) {
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
