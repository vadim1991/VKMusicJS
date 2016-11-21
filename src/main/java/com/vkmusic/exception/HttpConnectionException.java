package com.vkmusic.exception;

/**
 * Created by Vadym_Vlasenko on 9/8/2015.
 */
public class HttpConnectionException extends RuntimeException {

    public HttpConnectionException() {
    }

    public HttpConnectionException(String message) {
        super(message);
    }

    public HttpConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConnectionException(Throwable cause) {
        super(cause);
    }

    public HttpConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
