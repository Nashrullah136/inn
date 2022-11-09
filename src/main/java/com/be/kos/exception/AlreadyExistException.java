package com.be.kos.exception;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(){
        super("Data yang anda masukkan sudah ada");
    }
}
