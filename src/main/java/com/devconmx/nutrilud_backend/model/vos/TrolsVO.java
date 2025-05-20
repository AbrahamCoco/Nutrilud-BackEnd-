package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "trols")
@NamedQueries({
        @NamedQuery(name = "TrolsVO.findAllRols", query = "SELECT t FROM TrolsVO t WHERE t.estado = 1"),
})
@Data
public class TrolsVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rol;
    private int estado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
