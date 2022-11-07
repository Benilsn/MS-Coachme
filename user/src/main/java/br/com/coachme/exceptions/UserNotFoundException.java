package br.com.coachme.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }

}
