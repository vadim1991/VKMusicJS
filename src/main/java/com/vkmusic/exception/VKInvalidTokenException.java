package com.vkmusic.exception;

/**
 * Created by Vadym_Vlasenko on 5/20/2016.
 */
public class VKInvalidTokenException extends RuntimeException {

    public VKInvalidTokenException() {
    }

    public VKInvalidTokenException(String message) {
        super(message);
    }

    public VKInvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public VKInvalidTokenException(Throwable cause) {
        super(cause);
    }

    public VKInvalidTokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
