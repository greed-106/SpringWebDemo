package com.ymj.webdemo.exception;

public class WrongUsernameOrPasswordException extends RuntimeException{
    public WrongUsernameOrPasswordException(String message) {
        super(message);
    }

}
