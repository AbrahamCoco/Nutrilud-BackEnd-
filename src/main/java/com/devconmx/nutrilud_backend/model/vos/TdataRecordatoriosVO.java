package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tdatarecordatorio")
@NamedQueries({
    // Define any named queries here if needed
})
@Data
public class TdataRecordatoriosVO implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "t_recordatorio_id", referencedColumnName = "id")
  @JsonBackReference
  private T_recordatoriosVO t_recordatorio;

  private String comida;
  private String hora;
  private String lugar;
  private String alimentos;
  private String porciones;
  private String marca;
  private String preparacion;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
