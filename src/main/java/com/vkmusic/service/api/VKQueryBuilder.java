package com.vkmusic.service.api;

import com.vkmusic.entity.ResponseVK;
import com.vkmusic.entity.VKUserBean;
import com.vkmusic.entity.vk.AudioSearchBean;
import com.vkmusic.entity.vk.FriendParamBean;
import com.vkmusic.entity.vk.TrackParam;
import com.vkmusic.entity.vk.TrackRequest;
import com.vkmusic.exception.HttpConnectionException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

import static com.vkmusic.datamodel.VKApi.*;
import static com.vkmusic.datamodel.VKApiMethods.*;

/**
 * Created by Vadym_Vlasenko on 5/6/2016.
 */
@Service
public class VKQueryBuilder {

    public URI getURIAudio(VKUserBean userBean, TrackParam trackParam) {
        String ownerID = StringUtils.isBlank(trackParam.getOwnerID()) ? userBean.getId() : trackParam.getOwnerID();
        URIBuilder builder = getBuilderForVK(METHOD_AUDIO_GET)
                .setParameter(OWNER_ID_PARAM, ownerID)
                .setParameter(NEED_USER_PARAM, "0")
                .setParameter(COUNT_PARAM, String.valueOf(trackParam.getCount()))
                .setParameter(OFFSET_PARAM, String.valueOf(trackParam.getOffset()))
                .setParameter(ACCESS_TOKEN_PARAM, userBean.getResponseVK().getAccess_token());
        return buildURI(builder);
    }

    public URI getAudioByIDURI(VKUserBean userBean, String id) {
        URIBuilder builder = getBuilderForVK(AUDIO_GET_BY_ID_METHOD)
                .addParameter(AUDIOS_PARAM, id)
                .setParameter(ACCESS_TOKEN_PARAM, userBean.getResponseVK().getAccess_token());
        return buildURI(builder);
    }

    public URI getURIBySearchAudio(VKUserBean userBean, AudioSearchBean searchParam) {
        URIBuilder builder = getBuilderForVK(METHOD_AUDIO_SEARCH_GET)
                .setParameter(SEARCH_TEXT_PARAM, searchParam.getSearchText())
                .setParameter(AUTO_COMPLETE_PARAM, BooleanUtils.toString(searchParam.isAutocomplete(), "1", "0"))
                .setParameter(PERFORMER_ONLY_PARAM, BooleanUtils.toString(searchParam.isAutocomplete(), "1", "0"))
                .setParameter(SORT_PARAM, String.valueOf(searchParam.getSort()))
                .setParameter(SEARCH_OWN_PARAM, BooleanUtils.toString(searchParam.isSearchOwn(), "1", "0"))
                .setParameter(OFFSET_PARAM, String.valueOf(searchParam.getOffset()))
                .setParameter(COUNT_PARAM, String.valueOf(searchParam.getCount()))
                .setParameter(ACCESS_TOKEN_PARAM, userBean.getResponseVK().getAccess_token());
        return buildURI(builder);
    }

    public URI getFriendsURI(VKUserBean userBean, FriendParamBean friendParamBean) {
        URIBuilder builder = getBuilderForVK(METHOD_FRIENDS_GET)
                .setParameter(USER_ID_PARAM, userBean.getId())
                .setParameter(ORDER_PARAM, HINTS_ORDER_VALUE)
                .setParameter(FIELDS_PARAM, FIELD_VALUES)
                .setParameter(OFFSET_PARAM, String.valueOf(friendParamBean.getOffset()))
                .setParameter(COUNT_PARAM, String.valueOf(friendParamBean.getCount()))
                .setParameter(ACCESS_TOKEN_PARAM, userBean.getResponseVK().getAccess_token());
        return buildURI(builder);
    }

    public URI getGeneralInfo(ResponseVK responseVK, String fields) {
        URIBuilder builder = getBuilderForVK(METHOD_USERS_GET)
                .setParameter(UIDS_PARAM, responseVK.getUser_id())
                .setParameter(FIELDS_PARAM, fields)
                .setParameter(ACCESS_TOKEN_PARAM, responseVK.getAccess_token());
        return buildURI(builder);
    }

    public URI changeTrackURI(VKUserBean userBean, TrackRequest trackRequest, String vkMethod) {
        URIBuilder builder = getBuilderForVK(vkMethod)
                .setParameter(AUDIO_ID_PARAM, trackRequest.getAudioID())
                .setParameter(OWNER_ID_PARAM, trackRequest.getOwnerID())
                .setParameter(ACCESS_TOKEN_PARAM, userBean.getResponseVK().getAccess_token());
        return buildURI(builder);
    }

    private URI buildURI(URIBuilder builder) {
        URI uri;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            throw new HttpConnectionException(e.getCause());
        }
        return uri;
    }

    private URIBuilder getBuilderForVK(String method) {
        URIBuilder builder = new URIBuilder();
        return builder.setScheme(HTTPS_SCHEME).setHost(API_VK_COM_HOST).setPath(method);
    }

}
