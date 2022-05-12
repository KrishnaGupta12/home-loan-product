package com.lti.homeloanproductdescription.error;

public class HomeNotFoundException extends Exception {



    public HomeNotFoundException() {
        super();
    }

    public HomeNotFoundException(String message) {
        super(message);
    }

    public HomeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HomeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected HomeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}