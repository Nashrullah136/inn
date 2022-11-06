package com.be.kos.kosan;

public class KosanNotFoundException extends RuntimeException {

    KosanNotFoundException(Long id){
        super("Kosan dengan id " + id + " tidak ditemukan");
    }
}
