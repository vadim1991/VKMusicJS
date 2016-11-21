package com.vkmusic.entity.vk;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vadym_Vlasenko on 5/11/2016.
 */
public class PlayList implements Serializable {

    private List<Track> music;

    public PlayList(List<Track> music) {
        this.music = music;
    }

    public List<Track> getMusic() {
        return music;
    }

    public void setMusic(List<Track> music) {
        this.music = music;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return Objects.equal(music, playList.music);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(music);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "music=" + music +
                '}';
    }
}
