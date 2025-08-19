package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tdatos_consultas")
@NamedQueries({
        @NamedQuery(name = "Tdatos_consultasVO.findByNutriologoVO", query = "SELECT t FROM Tdatos_consultasVO t WHERE t.Tusuario_nutriologo.Tusuario_nutriologos.id = :id"),
        @NamedQuery(name = "Tdatos_consultasVO.findByPacienteVO", query = "SELECT t FROM Tdatos_consultasVO t WHERE t.Tusuario_paciente.Tusuario_pacientes.id = :id")
})
@Data
public class Tdatos_consultasVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "tusuario_paciente_id")
    private UsersVO Tusuario_paciente;
    private double peso;
    private double estatura;
    private double porcentaje_grasa;
    private double porcentaje_musculo;
    private double imc;
    private double circunferencia_cintura;
    private double circunferencia_cadera;
    private double circunferencia_brazo;
    private double pliegue_bicipital;
    private double pliegue_tricipital;
    private double glucosa;
    private double colesterol;
    private double trigliceridos;
    private String presion_arterial;
    private String fecha_medicion;
    private String siguiente_consulta;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
