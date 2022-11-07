package com.be.kos.penghuni;

import com.be.kos.bill.Bill;
import com.be.kos.kamar.Kamar;
import com.be.kos.kontak.Kontak;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "penghuni")
public class Penghuni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToOne
    @JoinColumn(name = "kamar_id")
    private Kamar kamar;

    @OneToMany(mappedBy = "penghuni", orphanRemoval = true)
    private List<Kontak> kontaks = new ArrayList<>();

    @OneToMany(mappedBy = "penghuni", orphanRemoval = true)
    private List<Bill> bills = new ArrayList<>();

    public List<Kontak> getKontaks() {
        return kontaks;
    }

    public void setKontaks(List<Kontak> kontaks) {
        this.kontaks = kontaks;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
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