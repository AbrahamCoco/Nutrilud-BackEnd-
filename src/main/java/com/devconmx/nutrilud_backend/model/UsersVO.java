package com.devconmx.nutrilud_backend.model;

import java.io.Serializable;

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
        @NamedQuery(name = "UsersVO.verifyUserRepository", query = "SELECT u FROM UsersVO u WHERE u.usuario = :usuario AND u.contrasenia = :contrasenia")
})
public class UsersVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

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
    private Long estado;
    private String remember_token;
    private String created_at;
    private String updated_at;

    public UsersVO() {
    }

    public UsersVO(Long id, TrolsVO trols, Tusuario_adminsVO tusuario_admins,
            Tusuario_nutriologosVO tusuario_nutriologos, Tusuario_pacientesVO tusuario_pacientes, String nombre,
            String primer_apellido, String segundo_apellido, String usuario, String correo, String email_verified_at,
            String contrasenia, Long estado, String remember_token, String created_at, String updated_at) {
        this.id = id;
        Trols = trols;
        Tusuario_admins = tusuario_admins;
        Tusuario_nutriologos = tusuario_nutriologos;
        Tusuario_pacientes = tusuario_pacientes;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.email_verified_at = email_verified_at;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.remember_token = remember_token;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
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
