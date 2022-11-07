package com.be.kos.kontak;

import com.be.kos.penghuni.Penghuni;

import javax.persistence.*;

@Entity
@Table(name = "kontak")
public class Kontak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama", nullable = false, length = 64)
    private String nama;

    @Column(name = "nomor", nullable = false, length = 16)
    private String nomor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "penghuni_id", nullable = false)
    private Penghuni penghuni;

    public Penghuni getPenghuni() {
        return penghuni;
    }

    public void setPenghuni(Penghuni penghuni) {
        this.penghuni = penghuni;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
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