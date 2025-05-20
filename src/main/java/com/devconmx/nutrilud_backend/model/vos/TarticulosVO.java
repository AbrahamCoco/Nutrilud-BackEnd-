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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tarticulos")
@NamedQueries({

})
@Data
public class TarticulosVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "nutriologo_id", referencedColumnName = "tusuario_nutriologo_id")
    private UsersVO Tusuario_nutriologo;

    private String contenido;
    private String foto;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
