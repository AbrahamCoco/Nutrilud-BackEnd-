package com.devconmx.nutrilud_backend.model.vos;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "personal_access_tokens")
@NamedQueries({})
@Data
public class Personal_access_tokenVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tokenable_type;
    private int tokenable_id;
    private String name;
    private String token;
    private String abilities;
    private String last_used_at;
    private String expires_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
