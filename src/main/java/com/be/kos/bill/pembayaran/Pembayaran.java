package com.be.kos.bill.pembayaran;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "jenis", nullable = false)
    private String jenis;

    @Column(name = "tanggal", nullable = false)
    private LocalDate tanggal;

    @Column(name = "jumlah", nullable = false)
    private Long jumlah;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pembayaran_id", nullable = false)
    private Pembayaran pembayaran;

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    @OneToMany(mappedBy = "pembayaran", orphanRemoval = true)
    private List<Pembayaran> pembayarans = new ArrayList<>();

    public List<Pembayaran> getPembayarans() {
        return pembayarans;
    }

    public void setPembayarans(List<Pembayaran> pembayarans) {
        this.pembayarans = pembayarans;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}