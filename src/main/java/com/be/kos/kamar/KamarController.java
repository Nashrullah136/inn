package com.be.kos.kamar;

import com.be.kos.kamar.harga.Harga;
import com.be.kos.kamar.harga.HargaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KamarController {

    private final KamarService kamarService;
    private final HargaService hargaService;

    KamarController(KamarService kamarService, HargaService hargaService){
        this.kamarService = kamarService;
        this.hargaService = hargaService;
    }

    @GetMapping("/kosan/{kosanId}/kamar")
    Iterable<KamarDto> allByKosanId(@PathVariable Long kosanId){
        Iterable<Kamar> listKamar = kamarService.getAllByKosanId(kosanId);
        List<KamarDto> listKamarDto = new ArrayList<>();
        listKamar.forEach(kamar -> listKamarDto.add(KamarDto.fromDao(kamar)));
        return listKamarDto;
    }

    @GetMapping("/kamar/{kamarId}")
    KamarDto findKamar(@PathVariable("kamarId") Long kamarId){
        Kamar kamar = kamarService.getById(kamarId);
        return KamarDto.fromDao(kamar);
    }

    @PostMapping("/kosan/{kosanId}/kamar")
    KamarDto newKamar(@RequestBody KamarDto kamarDto, @PathVariable Long kosanId){
        Kamar kamar = kamarDto.toDao();
        Kamar result = kamarService.save(kosanId, kamar);
        Iterable<Harga> resultListHarga = hargaService.saveAll(result.getId(), kamar.getHargas());
        result.setHargas((List<Harga>) resultListHarga);
        return KamarDto.fromDao(result);
    }

    @PutMapping("/kamar/{kamarId}")
    KamarDto updateKamar(@RequestBody KamarDto kamarDto, @PathVariable("kamarId") Long kamarId){
        Kamar updatedKamar = kamarDto.toDao();
        Kamar oldKamar = kamarService.update(kamarId, updatedKamar);
        Iterable<Harga> resultListHarga = hargaService.saveAll(oldKamar.getId(), updatedKamar.getHargas());
        oldKamar.setHargas((List<Harga>) resultListHarga);
        return KamarDto.fromDao(oldKamar);
    }

    @DeleteMapping("/kosan/{kosanId}/kamar")
    int deleteKamarWithKosan(@PathVariable Long kosanId){
        return kamarService.deleteALlByKosanId(kosanId);
    }

    @DeleteMapping("/kamar/{kamarId}")
    KamarDto deleteKamar(@PathVariable("kamarId") Long kamarId){
        Kamar existedKamar = kamarService.deleteById(kamarId);
        return KamarDto.fromDao(existedKamar);
    }

}
