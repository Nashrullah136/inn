package com.be.kos.kosan;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Kosan} entity
 */
public class KosanDto implements Serializable {
    private Long id;
    private String nama;
    private String alamat;

    public KosanDto() {
    }

    public KosanDto(Long id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public static KosanDto fromDao(Kosan kosan){
        return new KosanDto(kosan.getId(), kosan.getNama(), kosan.getAlamat());
    }

    public Kosan toDao(){
        Kosan result = new Kosan();
        result.setNama(this.nama);
        result.setAlamat(this.alamat);
        return result;
    }

    public Long getId() {
        return id;
    }

    public KosanDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNama() {
        return nama;
    }

    public KosanDto setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public String getAlamat() {
        return alamat;
    }

    public KosanDto setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KosanDto entity = (KosanDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nama, entity.nama) &&
                Objects.equals(this.alamat, entity.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nama = " + nama + ", " +
                "alamat = " + alamat + ")";
    }
}