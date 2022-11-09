package com.be.kos.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Data tidak ditemukan");
    }
}
