package com.devconmx.nutrilud_backend.model.vos;

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
import lombok.Data;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UsersVO.login", query = "SELECT u FROM UsersVO u WHERE u.usuario = :usuario AND u.contrasenia = :contrasenia"),
        @NamedQuery(name = "UsersVO.findByNutriologo", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_nutriologos.id = :id"),
        @NamedQuery(name = "UsersVO.findByPaciente", query = "SELECT u FROM UsersVO u WHERE u.Trols.id = 3 and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByIdPaciente", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_pacientes.id = :id and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByIdNutriologo", query = "SELECT u FROM UsersVO u WHERE u.Tusuario_nutriologos.id = :id and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findByUser", query = "SELECT u FROM UsersVO u WHERE u.usuario = :usuario and u.estado = 1"),
        @NamedQuery(name = "UsersVO.findAllAdminsAndNutris", query = "SELECT u FROM UsersVO u WHERE (u.Trols.id = 1 OR u.Trols.id = 2) AND u.estado = 1"),
        @NamedQuery(name = "UsersVO.findAllPacientes", query = "SELECT u FROM UsersVO u WHERE u.Trols.id = 3 AND u.estado = 1"),
})
@Data
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
}
