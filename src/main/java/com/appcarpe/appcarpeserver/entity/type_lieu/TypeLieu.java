package com.appcarpe.appcarpeserver.entity.type_lieu;

import com.appcarpe.appcarpeserver.entity.Lieu;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_lieu", schema = "public")
public class TypeLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TypeLieuEnum libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "typeLieu")
    private List<Lieu> lieux;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeLieuEnum getLibelle() {
        return libelle;
    }

    public void setLibelle(TypeLieuEnum libelle) {
        this.libelle = libelle;
    }

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieuEntities) {
        this.lieux = lieuEntities;
    }
}
