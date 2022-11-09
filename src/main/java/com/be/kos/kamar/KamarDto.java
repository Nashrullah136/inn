package com.be.kos.kamar;

import com.be.kos.kamar.harga.Harga;
import com.be.kos.kamar.harga.HargaDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Kamar} entity
 */
public class KamarDto implements Serializable {

    private Long id;
    private String nomor;
    private List<HargaDto> hargas = new ArrayList<>();

    public KamarDto() {
    }

    public Kamar toDao(){
        Kamar result = new Kamar();
        result.setNomor(this.nomor);
        List<Harga> tempHarga = new ArrayList<>();
        for (HargaDto hargaDto : this.hargas) {
            tempHarga.add(hargaDto.toDao());
        }
        result.setHargas(tempHarga);
        return result;
    }

    public static KamarDto fromDao(Kamar kamar){
        KamarDto kamarDto = new KamarDto();
        List<HargaDto> listHargaDto = new ArrayList<>();
        for (Harga harga :
                kamar.getHargas()) {
            listHargaDto.add(HargaDto.fromDao(harga));
        }
        kamarDto.setId(kamar.getId())
                .setNomor(kamar.getNomor())
                .setHargas(listHargaDto);
        return kamarDto;
    }

    public Long getId() {
        return id;
    }

    public KamarDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomor() {
        return nomor;
    }

    public KamarDto setNomor(String nomor) {
        this.nomor = nomor;
        return this;
    }

    public List<HargaDto> getHargas() {
        return hargas;
    }

    public KamarDto setHargas(List<HargaDto> hargas) {
        this.hargas = hargas;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KamarDto entity = (KamarDto) o;
        return Objects.equals(this.nomor, entity.nomor) &&
                Objects.equals(this.hargas, entity.hargas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomor, hargas);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nomor = " + nomor + ", " +
                "hargas = " + hargas + ")";
    }
}