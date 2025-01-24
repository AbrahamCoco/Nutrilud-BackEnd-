package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

public class T_recordatoriosDTO {
    private int id;
    private int nutriologo_id;
    private int paciente_id;
    private String recordatorio_pdf;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNutriologo_id() {
        return nutriologo_id;
    }

    public void setNutriologo_id(int nutriologo_id) {
        this.nutriologo_id = nutriologo_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getRecordatorio_pdf() {
        return recordatorio_pdf;
    }

    public void setRecordatorio_pdf(String recordatorio_pdf) {
        this.recordatorio_pdf = recordatorio_pdf;
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
