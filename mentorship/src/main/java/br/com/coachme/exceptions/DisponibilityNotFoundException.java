package br.com.coachme.exceptions;

public class DisponibilityNotFoundException extends RuntimeException{

    public DisponibilityNotFoundException(String msg){
        super(msg);
    }
}
