package com.vkmusic.entity.vk;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by Vadym on 30.06.2016.
 */
public class TrackRequest implements Serializable {

    private String audioID;
    private String ownerID;

    public String getAudioID() {
        return audioID;
    }

    public void setAudioID(String audioID) {
        this.audioID = audioID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("audioID", audioID)
                .add("ownerID", ownerID)
                .toString();
    }
}
