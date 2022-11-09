package com.be.kos.kamar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface KamarRepository extends CrudRepository<Kamar, Long> {
    List<Kamar> findByKosan_Id(@NonNull Long id);
}