package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;

@Entity
@Table(name = "tusuario_pacientes")
@NamedQueries({})
public class Tusuario_pacientesVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String telefono;
    private String fecha_nacimiento;
    private String sexo;
    private String alergias;
    private String created_at;
    private String updated_at;

    public Tusuario_pacientesVO() {
    }

    public Tusuario_pacientesVO(Long id, String foto, String telefono, String fecha_nacimiento, String sexo,
            String alergias, String created_at, String updated_at) {
        this.id = id;
        this.foto = foto;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.alergias = alergias;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
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
