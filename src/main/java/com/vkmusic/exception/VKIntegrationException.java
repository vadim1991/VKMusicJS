package com.vkmusic.exception;

/**
 * Created by Vadym_Vlasenko on 9/8/2015.
 */
public class VKIntegrationException extends RuntimeException {

    public VKIntegrationException() {
    }

    public VKIntegrationException(String message) {
        super(message);
    }

    public VKIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public VKIntegrationException(Throwable cause) {
        super(cause);
    }

    public VKIntegrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
