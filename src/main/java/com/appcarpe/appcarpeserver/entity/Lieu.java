package com.appcarpe.appcarpeserver.entity;

import com.appcarpe.appcarpeserver.entity.type_lieu.TypeLieu;
import com.appcarpe.appcarpeserver.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lieu", schema = "public")
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @Column(name = "prix_24")
    private Double prix24;

    @Column(name = "prix_journee")
    private Double prixJournee;

    private Boolean journee;

    @Column(name = "session_")
    private Boolean session;

    @Column(name = "bateau_amorceur")
    private Boolean bateauAmorceur;

    private Boolean navigation;

    private Double taille;

    @Column(name = "site_internet")
    private String siteInternet;

    @Column(name = "nombre_poste")
    private Integer nombrePoste;

    private String commentaire;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_situation_geographique")
    private SituationGeographique situationGeographique;

    @ManyToOne
    @JoinColumn(name = "id_type_lieu")
    private TypeLieu typeLieu;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

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

    public Double getPrix24() {
        return prix24;
    }

    public void setPrix24(Double prix24) {
        this.prix24 = prix24;
    }

    public Double getPrixJournee() {
        return prixJournee;
    }

    public void setPrixJournee(Double prixJournee) {
        this.prixJournee = prixJournee;
    }

    public Boolean getJournee() {
        return journee;
    }

    public void setJournee(Boolean journee) {
        this.journee = journee;
    }

    public Boolean getSession() {
        return session;
    }

    public void setSession(Boolean session) {
        this.session = session;
    }

    public Boolean getBateauAmorceur() {
        return bateauAmorceur;
    }

    public void setBateauAmorceur(Boolean bateauAmorceur) {
        this.bateauAmorceur = bateauAmorceur;
    }

    public Boolean getNavigation() {
        return navigation;
    }

    public void setNavigation(Boolean navigation) {
        this.navigation = navigation;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public Integer getNombrePoste() {
        return nombrePoste;
    }

    public void setNombrePoste(Integer nombrePoste) {
        this.nombrePoste = nombrePoste;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public SituationGeographique getSituationGeographique() {
        return situationGeographique;
    }

    public void setSituationGeographique(SituationGeographique situationGeographique) {
        this.situationGeographique = situationGeographique;
    }

    public TypeLieu getTypeLieu() {
        return typeLieu;
    }

    public void setTypeLieu(TypeLieu typeLieuEntity) {
        this.typeLieu = typeLieuEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
