package com.stackroute.mashupcontent.exceptions;

/*User defined exception for checking duplicate content*/
public class ContentAlreadyExistsException extends Exception {

    public ContentAlreadyExistsException(String message) {
        super(message);
    }
}
