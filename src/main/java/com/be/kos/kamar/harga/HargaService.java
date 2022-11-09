package com.be.kos.kamar.harga;

import com.be.kos.exception.NotFoundException;
import com.be.kos.kamar.Kamar;
import com.be.kos.kamar.KamarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HargaService {

    private final HargaRepository hargaRepository;
    private final KamarService kamarService;

    HargaService(HargaRepository hargaRepository, KamarService kamarService){
        this.hargaRepository = hargaRepository;
        this.kamarService = kamarService;
    }

    public Harga getById(Long id){
        return hargaRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    public Harga save(Long kamarId, Harga harga){
        Kamar kamar = kamarService.getById(kamarId);
        harga.setKamar(kamar);
        return hargaRepository.save(harga);
    }

    public Iterable<Harga> saveAll(Long kamarId, Iterable<Harga> hargas){
        deleteAllWithKamarId(kamarId);
        Kamar kamar = kamarService.getById(kamarId);
        for (Harga harga : hargas) {
            harga.setKamar(kamar);
        }
        return hargaRepository.saveAll(hargas);
    }

    public Harga update(Long id, Harga updatedHarga){
        Harga oldHarga = getById(id);
        oldHarga.setHarga(updatedHarga.getHarga());
        oldHarga.setJenis(updatedHarga.getJenis());
        return save(oldHarga.getKamar().getId(), oldHarga);
    }

    public Harga deleteById(Long id){
        Harga harga = getById(id);
        hargaRepository.delete(harga);
        return harga;
    }
    public int deleteAllWithKamarId(Long kamarId){
        List<Harga> listHarga = hargaRepository.findByKamar_Id(kamarId);
        hargaRepository.deleteAll(listHarga);
        return listHarga.size();
    }
}
