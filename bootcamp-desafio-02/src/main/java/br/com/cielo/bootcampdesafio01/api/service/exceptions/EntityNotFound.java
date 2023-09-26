package br.com.cielo.bootcampdesafio02.api.service.exceptions;

public class EntityNotFound extends RuntimeException{

    private static final Long serialVersionUUID = 1L;

    public EntityNotFound(String msg){
        super(msg);
    }
}
