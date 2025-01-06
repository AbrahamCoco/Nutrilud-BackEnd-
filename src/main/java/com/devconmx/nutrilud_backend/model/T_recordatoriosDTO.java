package com.devconmx.nutrilud_backend.model;

public class T_recordatoriosDTO {
    private Integer id;
    private Integer nutriologo_id;
    private Integer paciente_id;
    private String recordatorioPdf;
    private String created_at;
    private String updated_at;

    public T_recordatoriosDTO() {
    }

    public T_recordatoriosDTO(Integer id, Integer nutriologo_id, Integer paciente_id, String recordatorioPdf,
            String created_at, String updated_at) {
        this.id = id;
        this.nutriologo_id = nutriologo_id;
        this.paciente_id = paciente_id;
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

    public Integer getNutriologo_id() {
        return nutriologo_id;
    }

    public void setNutriologo_id(Integer nutriologo_id) {
        this.nutriologo_id = nutriologo_id;
    }

    public Integer getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
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
