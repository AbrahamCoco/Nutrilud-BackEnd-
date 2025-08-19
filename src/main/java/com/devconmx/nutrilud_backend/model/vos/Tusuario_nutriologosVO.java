package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tusuario_nutriologos")
@NamedQueries({})
@Data
public class Tusuario_nutriologosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String foto;
    private String direccion;
    private String telefono;
    private int cedula_profesional;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
