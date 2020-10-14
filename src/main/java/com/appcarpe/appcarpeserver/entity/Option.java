package com.appcarpe.appcarpeserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "option", schema = "public")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "share_lieu")
    private Boolean shareLieu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getShareLieu() {
        return shareLieu;
    }

    public void setShareLieu(Boolean shareLieu) {
        this.shareLieu = shareLieu;
    }
}
