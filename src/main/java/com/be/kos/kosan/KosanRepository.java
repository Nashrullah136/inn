package com.be.kos.kosan;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface KosanRepository extends CrudRepository<Kosan, Long> {
    @Override
    Optional<Kosan> findById(Long aLong);

    Optional<Kosan> findByNamaLikeIgnoreCase(String nama);

    Optional<Kosan> findByAlamatLikeIgnoreCase(String alamat);

    @Transactional
    @Modifying
    @Query("update Kosan k set k.nama = ?1, k.alamat = ?2 where k.id = ?3")
    int updateNamaAndAlamatById(@NonNull String nama, @Nullable String alamat, Long id);

    @Transactional
    @Modifying
    @Query("update Kosan k set k.deleted = true where k.id = :id")
    void deleteById(@Param("id") Long id);
}