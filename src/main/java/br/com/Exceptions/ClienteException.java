package br.com.Exceptions;

public class ClienteExistenteException extends Exception{

    public ClienteExistenteException(String error){
        super(error);
    }

}
