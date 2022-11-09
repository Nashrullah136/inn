package com.be.kos.kamar.harga;

import com.be.kos.kamar.Kamar;

import javax.persistence.*;

@Entity
@Table(name = "harga")
public class Harga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "jenis", nullable = false, length = 64)
    private String jenis;

    @Column(name = "harga", nullable = false)
    private Long harga;

    @ManyToOne(optional = false)
    @JoinColumn(name = "kamar_id", nullable = false)
    private Kamar kamar;

    public Harga(){}

    public Harga(String jenis, Long harga){
        this.jenis = jenis;
        this.harga = harga;
    }
    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}