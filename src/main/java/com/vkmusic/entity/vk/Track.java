package com.vkmusic.entity.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Vadym_Vlasenko on 5/9/2016.
 */
@Document
public class Track implements Serializable {

    @Id
    private String aid;
    @JsonProperty("owner_id")
    private String ownerID;
    private String artist;
    private String title;
    private String url;
    @JsonProperty("lyrics_id")
    private String lyricsID;
    private int duration;
    private int genre;
    private String album;
    private boolean soundcloud;
    private boolean added;
    private boolean delete;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    @JsonProperty("mp3")
    public String getMp3() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLyricsID() {
        return lyricsID;
    }

    public void setLyricsID(String lyricsID) {
        this.lyricsID = lyricsID;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean isSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(boolean soundcloud) {
        this.soundcloud = soundcloud;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("aid", aid)
                .add("ownerID", ownerID)
                .add("artist", artist)
                .add("title", title)
                .add("url", url)
                .add("lyricsID", lyricsID)
                .add("duration", duration)
                .add("genre", genre)
                .add("album", album)
                .toString();
    }
}
