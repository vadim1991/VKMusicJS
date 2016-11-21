package com.vkmusic.entity;

import java.io.Serializable;

/**
 * Created by Vadym_Vlasenko on 5/6/2016.
 */
public class AuthenticationConfig implements Serializable {

    private String vkClientID;
    private String vkClientSecret;

    public String getVkClientID() {
        return vkClientID;
    }

    public void setVkClientID(String vkClientID) {
        this.vkClientID = vkClientID;
    }

    public String getVkClientSecret() {
        return vkClientSecret;
    }

    public void setVkClientSecret(String vkClientSecret) {
        this.vkClientSecret = vkClientSecret;
    }
}
