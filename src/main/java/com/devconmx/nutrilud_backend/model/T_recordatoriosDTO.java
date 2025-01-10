package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

public class T_recordatoriosDTO {
    private Long id;
    private Long nutriologo_id;
    private Long paciente_id;
    private String recordatorioPdf;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public T_recordatoriosDTO() {
    }

    public T_recordatoriosDTO(Long id, Long nutriologo_id, Long paciente_id, String recordatorioPdf,
            LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.nutriologo_id = nutriologo_id;
        this.paciente_id = paciente_id;
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

    public Long getNutriologo_id() {
        return nutriologo_id;
    }

    public void setNutriologo_id(Long nutriologo_id) {
        this.nutriologo_id = nutriologo_id;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
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
