package com.shopping.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="roles")
public class UserRole implements Serializable {
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
     @Column(name ="role", nullable = false)
    private String role;
     
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles", 
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="userId")}
    )
    private Set<User> userRoles;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
 
    public Set<User> getUserRoles() {
        return userRoles;
    }
 
    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }
     
}