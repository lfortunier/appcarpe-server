package com.appcarpe.appcarpeserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "situation_geographique", schema = "public")
public class SituationGeographique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_ville")
    private String nomVille;

    @Column(name = "code_postal")
    private String codePostal;

    private String departement;

    @JsonIgnore
    @OneToMany(mappedBy="situationGeographique")
    private List<Lieu> lieux;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieuEntities) {
        this.lieux = lieuEntities;
    }
}
