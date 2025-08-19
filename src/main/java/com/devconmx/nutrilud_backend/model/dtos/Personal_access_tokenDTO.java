package com.devconmx.nutrilud_backend.model.dtos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Personal_access_tokenDTO {
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
