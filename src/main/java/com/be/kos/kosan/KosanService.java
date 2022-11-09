package com.be.kos.kosan;

import com.be.kos.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KosanService {

    private final KosanRepository kosanRepository;

    KosanService(KosanRepository kosanRepository){
        this.kosanRepository = kosanRepository;
    }

    public  Kosan getById(Long id){
        return kosanRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Kosan> getAll(){
        return kosanRepository.findAll();
    }

    public Kosan save(Kosan kosan){
        return kosanRepository.save(kosan);
    }

    public Kosan update(Long id, Kosan updatedKosan){
        Kosan oldKosan = getById(id);
        oldKosan.setNama(updatedKosan.getNama());
        oldKosan.setAlamat(updatedKosan.getAlamat());
        oldKosan.setId(id);
        return save(oldKosan);
    }

    public Kosan deleteById(Long id){
        Kosan kosan = getById(id);
        kosanRepository.delete(kosan);
        return kosan;
    }
}
