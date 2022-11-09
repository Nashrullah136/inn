package com.be.kos.kamar.harga;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.be.kos.kamar.harga.Harga} entity
 */
public class HargaDto implements Serializable {

    private Long id;
    private String jenis;
    private Long harga;

    public HargaDto() {
    }

    public HargaDto(String jenis, Long harga) {
        this.jenis = jenis;
        this.harga = harga;
    }

    public Harga toDao(){
        return new Harga(this.jenis, this.harga);
    }

    public static HargaDto fromDao(Harga harga){
        HargaDto hargaDto = new HargaDto();
        hargaDto.setId(harga.getId())
                .setJenis(harga.getJenis())
                .setHarga(harga.getHarga());
        return hargaDto;
    }

    public Long getId() {
        return id;
    }

    public HargaDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getJenis() {
        return jenis;
    }

    public HargaDto setJenis(String jenis) {
        this.jenis = jenis;
        return this;
    }

    public Long getHarga() {
        return harga;
    }

    public HargaDto setHarga(Long harga) {
        this.harga = harga;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HargaDto entity = (HargaDto) o;
        return Objects.equals(this.jenis, entity.jenis) &&
                Objects.equals(this.harga, entity.harga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jenis, harga);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "jenis = " + jenis + ", " +
                "harga = " + harga + ")";
    }
}