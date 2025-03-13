package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UsersVO.login", query = "SELECT u FROM UsersVO u WHERE u.usuario = :usuario AND u.contrasenia = :contrasenia"),
        @NamedQuery(name = "UsersVO.findByNutriologo", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_nutriologos.id = :id"),
        @NamedQuery(name = "UsersVO.findByPaciente", query = "SELECT u FROM UsersVO u WHERE u.Trols.id = 3 and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByIdPaciente", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_pacientes.id = :id and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByIdNutriologo", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_nutriologos.id = :id and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByUser", query = "SELECT u FROM UsersVO u WHERE u.usuario = :usuario and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findAllAdminsAndNutris", query = "SELECT u FROM UsersVO u WHERE u.Trols.id = 1 or u.Trols.id = 2 and u.estado = 1")
})
public class UsersVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "trol_id", referencedColumnName = "id")
    private TrolsVO Trols;

    @ManyToOne
    @JoinColumn(name = "tusuario_admin_id", referencedColumnName = "id")
    private Tusuario_adminsVO Tusuario_admins;

    @ManyToOne
    @JoinColumn(name = "tusuario_nutriologo_id", referencedColumnName = "id")
    private Tusuario_nutriologosVO Tusuario_nutriologos;

    @ManyToOne
    @JoinColumn(name = "tusuario_paciente_id", referencedColumnName = "id")
    private Tusuario_pacientesVO Tusuario_pacientes;

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

    public TrolsVO getTrols() {
        return Trols;
    }

    public void setTrols(TrolsVO trols) {
        Trols = trols;
    }

    public Tusuario_adminsVO getTusuario_admins() {
        return Tusuario_admins;
    }

    public void setTusuario_admins(Tusuario_adminsVO tusuario_admins) {
        Tusuario_admins = tusuario_admins;
    }

    public Tusuario_nutriologosVO getTusuario_nutriologos() {
        return Tusuario_nutriologos;
    }

    public void setTusuario_nutriologos(Tusuario_nutriologosVO tusuario_nutriologos) {
        Tusuario_nutriologos = tusuario_nutriologos;
    }

    public Tusuario_pacientesVO getTusuario_pacientes() {
        return Tusuario_pacientes;
    }

    public void setTusuario_pacientes(Tusuario_pacientesVO tusuario_pacientes) {
        Tusuario_pacientes = tusuario_pacientes;
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
}
