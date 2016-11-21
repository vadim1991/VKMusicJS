package com.vkmusic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Created by Vadym_Vlasenko on 9/17/2015.
 */
@Document
public class VKUserBean {

    @Id
    @JsonProperty("uid")
    private String id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private int sex;
    @JsonProperty("nickname")
    private String nickName;
    @JsonProperty("screen_name")
    private String screenName;
    @JsonProperty("photo_50")
    private String photoUrl;
    private String online;
    @JsonProperty("user_id")
    private String userID;
    private List<String> lists;
    @Transient
    private ResponseVK responseVK;
    private Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ResponseVK getResponseVK() {
        return responseVK;
    }

    public void setResponseVK(ResponseVK responseVK) {
        this.responseVK = responseVK;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VKUserBean that = (VKUserBean) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(firstName, that.firstName) &&
                Objects.equal(lastName, that.lastName) &&
                Objects.equal(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, firstName, lastName, nickName);
    }

    @Override
    public String toString() {
        return "VKUserBean{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                ", screenName='" + screenName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

}
