package com.be.kos.bill;

import com.be.kos.penghuni.Penghuni;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tanggal_akhir", nullable = false)
    private LocalDate tanggalAkhir;

    @Column(name = "tanggal_mulai", nullable = false)
    private LocalDate tanggalMulai;

    @Column(name = "kamar", nullable = false)
    private String kamar;

    @Column(name = "kosan", nullable = false)
    private String kosan;

    @Column(name = "harga", nullable = false)
    private Long harga;

    @ManyToOne(optional = false)
    @JoinColumn(name = "penghuni_id", nullable = false)
    private Penghuni penghuni;

    public Penghuni getPenghuni() {
        return penghuni;
    }

    public void setPenghuni(Penghuni penghuni) {
        this.penghuni = penghuni;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public String getKamar() {
        return kamar;
    }

    public void setKamar(String kamar) {
        this.kamar = kamar;
    }

    public String getKosan() {
        return kosan;
    }

    public void setKosan(String kosan) {
        this.kosan = kosan;
    }

    public LocalDate getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(LocalDate tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}