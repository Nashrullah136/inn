package com.be.kos.kamar;

import com.be.kos.harga.Harga;
import com.be.kos.kosan.Kosan;
import com.be.kos.penghuni.Penghuni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kamar")
public class Kamar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nomor", nullable = false, length = 16)
    private String nomor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "kosan_id", nullable = false)
    private Kosan kosan;

    @OneToMany(mappedBy = "kamar", orphanRemoval = true)
    private List<Penghuni> penghunis = new ArrayList<>();

    @OneToMany(mappedBy = "kamar", orphanRemoval = true)
    private List<Harga> hargas = new ArrayList<>();

    public List<Penghuni> getPenghunis() {
        return penghunis;
    }

    public void setPenghunis(List<Penghuni> penghunis) {
        this.penghunis = penghunis;
    }

    public List<Harga> getHargas() {
        return hargas;
    }

    public void setHargas(List<Harga> hargas) {
        this.hargas = hargas;
    }

    public Kosan getKosan() {
        return kosan;
    }

    public void setKosan(Kosan kosan) {
        this.kosan = kosan;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}