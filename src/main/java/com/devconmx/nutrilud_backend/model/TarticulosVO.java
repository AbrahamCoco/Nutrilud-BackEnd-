package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarticulos")
@NamedQueries({

})
public class TarticulosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    private String contenido;
    private String foto;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public TarticulosVO() {
    }

    public TarticulosVO(Long id, UsersVO tusuario_nutriologo, String contenido, String foto, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        Tusuario_nutriologo = tusuario_nutriologo;
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

    public UsersVO getTusuario_nutriologo() {
        return Tusuario_nutriologo;
    }

    public void setTusuario_nutriologo(UsersVO tusuario_nutriologo) {
        Tusuario_nutriologo = tusuario_nutriologo;
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
