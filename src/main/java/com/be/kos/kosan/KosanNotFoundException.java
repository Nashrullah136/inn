package com.be.kos.kosan;

public class KosanNotFoundException extends RuntimeException {

    public KosanNotFoundException(Long id){
        super("Kosan dengan id " + id + " tidak ditemukan");
    }
}
