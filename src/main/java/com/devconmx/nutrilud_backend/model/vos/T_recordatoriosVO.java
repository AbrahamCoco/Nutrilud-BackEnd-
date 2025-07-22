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
@Table(name = "t_recordatorios")
@NamedQueries({
        @NamedQuery(name = "T_recordatoriosVO.findRecordatorioByPacienteId", query = "SELECT t FROM T_recordatoriosVO t WHERE t.Tusuario_paciente.Tusuario_pacientes.id = :id")
})
@Data
public class T_recordatoriosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "tusuario_paciente_id")
    private UsersVO Tusuario_paciente;
    private String otros;
    private String observaciones;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
