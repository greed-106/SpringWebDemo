package com.ymj.webdemo.exception;

public class WrongCaptchaException extends RuntimeException{
    public WrongCaptchaException(String message) {
        super(message);
    }
}
