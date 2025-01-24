package com.devconmx.nutrilud_backend.model;

public class UsersDTO {
    private int id;
    private int rol_id;
    private int tusuario_admin_id;
    private int tusuario_nutriologo_id;
    private int tusuario_paciente_id;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String usuario;
    private String correo;
    private String email_verified_at;
    private String contrasenia;
    private int estado;
    private String remember_token;
    private String created_at;
    private String updated_at;

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
