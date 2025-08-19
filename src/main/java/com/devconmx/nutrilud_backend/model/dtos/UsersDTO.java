package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsersDTO {
    private int id;
    private int rol_id;

    private int tusuario_admin_id;
    private String descripcion_admin;
    private String foto_admin;
    private String telefono_admin;

    private int tusuario_nutriologo_id;
    private String descripcion_nutriologo;
    private String foto_nutriologo;
    private String direccion_nutriologo;
    private String telefono_nutriologo;
    private int cedula_profesional_nutriologo;

    private int tusuario_paciente_id;
    private String foto_paciente;
    private String telefono_paciente;
    private LocalDate fecha_nacimiento_paciente;
    private String sexo_paciente;
    private String alergias_paciente;

    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String usuario;
    private String correo;
    private String email_verified_at;
    private String contrasenia;
    private int estado;
    private String remember_token;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
