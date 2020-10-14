package com.appcarpe.appcarpeserver.entity.user;

import com.appcarpe.appcarpeserver.entity.Lieu;
import com.appcarpe.appcarpeserver.entity.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email(message = "L'email doit être valide")
    @NotNull
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8)
    @NotNull
    private String password;

    private String firstname;

    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_option")
    private Option option;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Lieu> lieuEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String mdp) {
        this.password = mdp;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Option getOptionEntity() {
        return option;
    }

    public void setOptionEntity(Option option) {
        this.option = option;
    }

    public List<Lieu> getLieuEntities() {
        return lieuEntities;
    }

    public void setLieuEntities(List<Lieu> lieuEntities) {
        this.lieuEntities = lieuEntities;
    }
}
