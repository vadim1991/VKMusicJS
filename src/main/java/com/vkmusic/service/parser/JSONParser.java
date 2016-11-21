package com.vkmusic.service.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkmusic.entity.ResponseVK;
import com.vkmusic.entity.Role;
import com.vkmusic.entity.VKUserBean;
import com.vkmusic.entity.vk.Track;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.vkmusic.datamodel.CommonConstants.USER_ROLE;

/**
 * Created by Vadym_Vlasenko on 5/6/2016.
 */
@Service
public class JSONParser {

    public static final String LEFT_SLASH = "\\/";
    public static final String RIGHT_SLASH = "/";
    public static final String RESPONSE = "response";

    @Autowired
    private ObjectMapper objectMapper;

    public VKUserBean getVKUserBean(String response) throws IOException {
        return getUserBeanListFromResponse(response).get(0);
    }

    public List<VKUserBean> getVKUserBeanList(String response) throws IOException {
        return getUserBeanListFromResponse(response);
    }

    public ResponseVK getResponseVK(String response) throws IOException {
        return objectMapper.readValue(response, ResponseVK.class);
    }

    public List<Track> getTracks(String response, boolean isMyTracks) throws IOException {
        List<Track> tracks = new ArrayList<>();
        JsonNode jsonNode = objectMapper.readTree(response);
        JsonNode trackNodes = jsonNode.get(RESPONSE);
        for (JsonNode trackNode : trackNodes) {
            if (trackNode.isInt()) {
                continue;
            }
            Track track = objectMapper.readValue(trackNode.toString(), Track.class);
            track.setUrl(track.getUrl().replaceAll(LEFT_SLASH, RIGHT_SLASH));
            track.setSoundcloud(true);
            track.setAdded(!isMyTracks);
            track.setDelete(isMyTracks);
            tracks.add(track);
        }
        return tracks;
    }

    private List<VKUserBean> getUserBeanListFromResponse(String response) throws IOException {
        List<VKUserBean> userBeanList = new ArrayList<>();
        JsonNode jsonNode = objectMapper.readTree(response);
        JsonNode trackNodes = jsonNode.get(RESPONSE);
        for (JsonNode userNode : trackNodes) {
            if (userNode.isInt()) {
                continue;
            }
            VKUserBean userBean = objectMapper.readValue(userNode.toString(), VKUserBean.class);
            String photoUrl = userBean.getPhotoUrl();
            if (StringUtils.isNoneBlank(photoUrl)) {
                userBean.setPhotoUrl(photoUrl.replaceAll(LEFT_SLASH, RIGHT_SLASH));
            }
            setUserRole(userBean);
            userBeanList.add(userBean);
        }
        return userBeanList;
    }

    private void setUserRole(VKUserBean vkUserBean) {
        Set<Role> roles = new HashSet<>();
        roles.add(USER_ROLE);
        vkUserBean.setRoles(roles);
    }

}
