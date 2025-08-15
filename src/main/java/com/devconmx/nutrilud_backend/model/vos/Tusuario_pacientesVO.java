package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tusuario_pacientes")
@NamedQueries({})
@Data
public class Tusuario_pacientesVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String foto;
    private String telefono;
    private LocalDate fecha_nacimiento;
    private String sexo;
    private String alergias;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
