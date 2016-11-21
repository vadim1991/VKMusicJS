package com.vkmusic.entity.vk;

import java.io.Serializable;

/**
 * Created by Vadym_Vlasenko on 5/18/2016.
 */
public class FriendParamBean implements Serializable {

    private String fields;
    private int offset;
    private int count;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FriendParamBean{" +
                ", fields='" + fields + '\'' +
                ", offset=" + offset +
                ", count=" + count +
                '}';
    }
}
