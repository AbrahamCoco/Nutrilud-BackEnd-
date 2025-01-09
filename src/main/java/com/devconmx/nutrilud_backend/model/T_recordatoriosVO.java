package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;

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
@Table(name = "t_recordatorios")
@NamedQueries({})
public class T_recordatoriosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "tusuario_paciente_id")
    private UsersVO Tusuario_paciente;

    @Column
    private String recordatorioPdf;

    @Column
    private String created_at;

    @Column
    private String updated_at;

    public T_recordatoriosVO() {
    }

    public T_recordatoriosVO(Integer id, UsersVO tusuario_nutriologo, UsersVO tusuario_paciente, String recordatorioPdf,
            String created_at, String updated_at) {
        this.id = id;
        Tusuario_nutriologo = tusuario_nutriologo;
        Tusuario_paciente = tusuario_paciente;
        this.recordatorioPdf = recordatorioPdf;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
