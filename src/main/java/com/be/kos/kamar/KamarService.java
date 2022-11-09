package com.be.kos.kamar;

import com.be.kos.exception.NotFoundException;
import com.be.kos.kosan.Kosan;
import com.be.kos.kosan.KosanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KamarService {

    private final KamarRepository kamarRepository;
    private final KosanService kosanService;

    @Autowired
    KamarService(KamarRepository kamarRepository, KosanService kosanService){
        this.kamarRepository = kamarRepository;
        this.kosanService = kosanService;
    }

    public Kamar getById(Long id){
        return kamarRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Kamar> getAllByKosanId(Long kosanId){
        return kamarRepository.findByKosan_Id(kosanId);
    }

    public Kamar save(Long kosanId, Kamar kamar){
        Kosan kosan = kosanService.getById(kosanId);
        kamar.setKosan(kosan);
        return kamarRepository.save(kamar);
    }

    public Kamar update(Long kamarId, Kamar updatedKamar){
        Kamar oldKamar = getById(kamarId);
        oldKamar.setNomor(updatedKamar.getNomor());
        return save(oldKamar.getKosan().getId(), oldKamar);
    }

    public Kamar deleteById(Long kamarId){
        Kamar kamar = getById(kamarId);
        kamarRepository.deleteById(kamarId);
        return kamar;
    }
    public int deleteALlByKosanId(Long kosanId){
        List<Kamar> kamarList = kamarRepository.findByKosan_Id(kosanId);
        kamarRepository.deleteAll(kamarList);
        return kamarList.size();
    }
}
