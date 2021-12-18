package com.book.exception;

public class BookNotFoundException extends Throwable{

    public BookNotFoundException(String msg){
        super(msg);
    }
}
