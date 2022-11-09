package com.be.kos.kamar.harga;

import org.springframework.web.bind.annotation.*;

@RestController
public class HargaController {
    private final HargaService hargaService;

    HargaController(HargaService hargaService){
        this.hargaService = hargaService;
    }

    @PostMapping("/kamar/{kamarId}/harga")
    HargaDto newHargaWithKamar(@RequestBody HargaDto hargaDto, @PathVariable("kamarId") Long kamarId){
        Harga harga = hargaDto.toDao();
        harga = hargaService.save(kamarId, harga);
        return HargaDto.fromDao(harga);
    }

    @PutMapping("/harga/{hargaId}")
    HargaDto updateHarga(@RequestBody HargaDto hargaDto, @PathVariable("hargaId") Long hargaId){
        Harga updatedHarga = hargaDto.toDao();
        updatedHarga = hargaService.update(hargaId, updatedHarga);
        return HargaDto.fromDao(updatedHarga);
    }

    @DeleteMapping("/kamar/{kamarId}/harga")
    int deleteAllHargaWithKamar(@PathVariable("kamarId") Long kamarId){
        return hargaService.deleteAllWithKamarId(kamarId);
    }

    @DeleteMapping("/harga/{hargaId}")
    HargaDto deleteHarga(@PathVariable("hargaId") Long hargaId){
        Harga deletedHarga = hargaService.deleteById(hargaId);
        return HargaDto.fromDao(deletedHarga);
    }
}
