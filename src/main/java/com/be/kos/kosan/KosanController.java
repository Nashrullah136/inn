package com.be.kos.kosan;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class KosanController {

    private final KosanRepository kosanRepository;

    KosanController(KosanRepository kosanRepository){
        this.kosanRepository = kosanRepository;
    }

    @GetMapping("/kosan")
    Iterable<Kosan> all(){
        return kosanRepository.findAll();
    }

    @PostMapping("/kosan")
    Kosan newKosan(@RequestBody Kosan kosan){
        return kosanRepository.save(kosan);
    }

    @PutMapping("/kosan/{id}")
    Kosan updateKosan(@RequestBody Kosan newKosan, @PathVariable Long id){
        return kosanRepository.findById(id).map( kosan -> {
            kosan.setNama(newKosan.getNama());
            kosan.setAlamat(newKosan.getAlamat());
            return kosanRepository.save(kosan);
        }).orElseGet(() -> {
            newKosan.setId(id);
            return kosanRepository.save(newKosan);
        });
    }

    @DeleteMapping("/kosan/{id}")
    Optional<Kosan> deleteKosan(@PathVariable Long id){
        Optional<Kosan> deletedKosan = kosanRepository.findById(id);
        deletedKosan.map(kosan -> {
            kosanRepository.deleteById(kosan.getId());
            return kosan;
        }).orElseThrow(() -> new KosanNotFoundException(id));
        return deletedKosan;
    }

}
