package com.be.kos.kosan;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class KosanController {

    private final KosanService kosanService;

    KosanController(KosanService kosanService){
        this.kosanService = kosanService;
    }

    @GetMapping("/kosan")
    Iterable<KosanDto> all(){
        Iterable<Kosan> kosanIterable = kosanService.getAll();
        List<KosanDto> kosanDtoList = new ArrayList<>();
        kosanIterable.forEach(kosan -> kosanDtoList.add(KosanDto.fromDao(kosan)));
        return kosanDtoList;
    }

    @PostMapping("/kosan")
    KosanDto newKosan(@RequestBody Kosan kosan){
        Kosan newKosan = kosanService.save(kosan);
        return KosanDto.fromDao(newKosan);
    }

    @PutMapping("/kosan/{id}")
    KosanDto updateKosan(@RequestBody KosanDto kosanDto, @PathVariable Long id){
        Kosan updatedKosan = kosanDto.toDao();
        updatedKosan = kosanService.update(id, updatedKosan);
        return KosanDto.fromDao(updatedKosan);
    }

    @DeleteMapping("/kosan/{id}")
    KosanDto deleteKosan(@PathVariable Long id){
        Kosan kosan = kosanService.deleteById(id);
        return KosanDto.fromDao(kosan);
    }

}
