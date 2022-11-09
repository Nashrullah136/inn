package com.be.kos.kamar.harga;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface HargaRepository extends CrudRepository<Harga, Long> {
    List<Harga> findByKamar_Id(@NonNull Long id);
}