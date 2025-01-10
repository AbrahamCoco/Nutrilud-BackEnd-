package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_recordatorios")
@NamedQueries({})
public class T_recordatoriosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "tusuario_paciente_id")
    private UsersVO Tusuario_paciente;
    private String recordatorioPdf;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public T_recordatoriosVO() {
    }

    public T_recordatoriosVO(Long id, UsersVO tusuario_nutriologo, UsersVO tusuario_paciente, String recordatorioPdf,
            LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        Tusuario_nutriologo = tusuario_nutriologo;
        Tusuario_paciente = tusuario_paciente;
        this.recordatorioPdf = recordatorioPdf;
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

    public UsersVO getTusuario_paciente() {
        return Tusuario_paciente;
    }

    public void setTusuario_paciente(UsersVO tusuario_paciente) {
        Tusuario_paciente = tusuario_paciente;
    }

    public String getRecordatorioPdf() {
        return recordatorioPdf;
    }

    public void setRecordatorioPdf(String recordatorioPdf) {
        this.recordatorioPdf = recordatorioPdf;
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
