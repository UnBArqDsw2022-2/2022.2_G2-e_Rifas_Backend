package com.erifas.backend.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Map;

@Entity
@Table(schema = "auth", name = "user_entity")
@JsonIgnoreProperties
public class Usuario {
    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String first_name;
    @JsonProperty("lastName")
    private String last_name;

    @JsonProperty("attributes")
    private Map<String, String> attributes;

    @JsonProperty("realmId")
    private String realm_id;

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(), getId());
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRealm_id() {
        return realm_id;
    }

    public void setRealm_id(String realm_id) {
        this.realm_id = realm_id;
    }
}
