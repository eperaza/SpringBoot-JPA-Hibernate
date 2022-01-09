package com.example.jpa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Entity(name = "user")
@Table(name = "user")
//@SecondaryTable(name = "roles", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_user"))
@Component
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    //@Column(name = "role", table = "roles")
    //String role;
    @ManyToOne(cascade = CascadeType.ALL/*, fetch = FetchType.LAZY*/)
    @JoinColumn(name = "id_role", referencedColumnName = "id", updatable=false, insertable = false)
    private Role role;
    
    //create another invisible column to insert "id_role" field
    @JsonIgnore
    @Column(name = "id_role", nullable = true)
    private Integer rol;
    /*
    public Integer getId_role() {
        return id_role;
    }
    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }
    */
    public Integer getRol() {
        return rol;
    }
    public void setRol(Integer rol) {
        this.rol = rol;
    }
    public Integer getId() {  
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole(){
        return role;
    }
    
}
