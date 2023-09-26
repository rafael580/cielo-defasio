package br.com.cielo.bootcampdesafio03.api.service.exceptions;

public class DataBaseException extends RuntimeException{

    private static final Long serialVersionUUID = 1L;

    public DataBaseException(String msg){
        super(msg);
    }
}
