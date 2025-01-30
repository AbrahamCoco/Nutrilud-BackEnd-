package com.devconmx.nutrilud_backend.model;

import java.time.LocalDateTime;

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
    private LocalDateTime fecha_nacimiento_paciente;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getTusuario_admin_id() {
        return tusuario_admin_id;
    }

    public void setTusuario_admin_id(int tusuario_admin_id) {
        this.tusuario_admin_id = tusuario_admin_id;
    }

    public int getTusuario_nutriologo_id() {
        return tusuario_nutriologo_id;
    }

    public void setTusuario_nutriologo_id(int tusuario_nutriologo_id) {
        this.tusuario_nutriologo_id = tusuario_nutriologo_id;
    }

    public int getTusuario_paciente_id() {
        return tusuario_paciente_id;
    }

    public void setTusuario_paciente_id(int tusuario_paciente_id) {
        this.tusuario_paciente_id = tusuario_paciente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
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

    public String getDescripcion_admin() {
        return descripcion_admin;
    }

    public void setDescripcion_admin(String descripcion_admin) {
        this.descripcion_admin = descripcion_admin;
    }

    public String getFoto_admin() {
        return foto_admin;
    }

    public void setFoto_admin(String foto_admin) {
        this.foto_admin = foto_admin;
    }

    public String getTelefono_admin() {
        return telefono_admin;
    }

    public void setTelefono_admin(String telefono_admin) {
        this.telefono_admin = telefono_admin;
    }

    public String getDescripcion_nutriologo() {
        return descripcion_nutriologo;
    }

    public void setDescripcion_nutriologo(String descripcion_nutriologo) {
        this.descripcion_nutriologo = descripcion_nutriologo;
    }

    public String getFoto_nutriologo() {
        return foto_nutriologo;
    }

    public void setFoto_nutriologo(String foto_nutriologo) {
        this.foto_nutriologo = foto_nutriologo;
    }

    public String getDireccion_nutriologo() {
        return direccion_nutriologo;
    }

    public void setDireccion_nutriologo(String direccion_nutriologo) {
        this.direccion_nutriologo = direccion_nutriologo;
    }

    public String getTelefono_nutriologo() {
        return telefono_nutriologo;
    }

    public void setTelefono_nutriologo(String telefono_nutriologo) {
        this.telefono_nutriologo = telefono_nutriologo;
    }

    public int getCedula_profesional_nutriologo() {
        return cedula_profesional_nutriologo;
    }

    public void setCedula_profesional_nutriologo(int cedula_profesional_nutriologo) {
        this.cedula_profesional_nutriologo = cedula_profesional_nutriologo;
    }

    public String getFoto_paciente() {
        return foto_paciente;
    }

    public void setFoto_paciente(String foto_paciente) {
        this.foto_paciente = foto_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public LocalDateTime getFecha_nacimiento_paciente() {
        return fecha_nacimiento_paciente;
    }

    public void setFecha_nacimiento_paciente(LocalDateTime fecha_nacimiento_paciente) {
        this.fecha_nacimiento_paciente = fecha_nacimiento_paciente;
    }

    public String getSexo_paciente() {
        return sexo_paciente;
    }

    public void setSexo_paciente(String sexo_paciente) {
        this.sexo_paciente = sexo_paciente;
    }

    public String getAlergias_paciente() {
        return alergias_paciente;
    }

    public void setAlergias_paciente(String alergias_paciente) {
        this.alergias_paciente = alergias_paciente;
    }
}
