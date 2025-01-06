package com.devconmx.nutrilud_backend.model;

public class Personal_access_tokenDTO {
    private Integer id;
    private Integer tokenable_type;
    private Integer tokenable_id;
    private String name;
    private String token;
    private String abilities;
    private String last_used_at;
    private String expires_at;
    private String created_at;
    private String updated_at;

    public Personal_access_tokenDTO() {
    }

    public Personal_access_tokenDTO(Integer id, Integer tokenable_type, Integer tokenable_id, String name, String token,
            String abilities, String last_used_at, String expires_at, String created_at, String updated_at) {
        this.id = id;
        this.tokenable_type = tokenable_type;
        this.tokenable_id = tokenable_id;
        this.name = name;
        this.token = token;
        this.abilities = abilities;
        this.last_used_at = last_used_at;
        this.expires_at = expires_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTokenable_type() {
        return tokenable_type;
    }

    public void setTokenable_type(Integer tokenable_type) {
        this.tokenable_type = tokenable_type;
    }

    public Integer getTokenable_id() {
        return tokenable_id;
    }

    public void setTokenable_id(Integer tokenable_id) {
        this.tokenable_id = tokenable_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getLast_used_at() {
        return last_used_at;
    }

    public void setLast_used_at(String last_used_at) {
        this.last_used_at = last_used_at;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
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
