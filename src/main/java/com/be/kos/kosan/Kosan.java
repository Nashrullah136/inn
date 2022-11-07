package com.be.kos.kosan;


import com.be.kos.kamar.Kamar;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public
class Kosan{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @JsonIgnore
    @Column(name = "deleted")
    private Boolean deleted;

    protected  Kosan(){}

    public Kosan(String nama, String alamat){
        this.alamat = alamat;
        this.nama = nama;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    @OneToMany(mappedBy = "kosan", orphanRemoval = true)
    private List<Kamar> kamars = new ArrayList<>();

    public List<Kamar> getKamars() {
        return kamars;
    }

    public void setKamars(List<Kamar> kamars) {
        this.kamars = kamars;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
