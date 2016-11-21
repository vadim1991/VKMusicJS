package com.vkmusic.controller;

import com.vkmusic.datamodel.CommonConstants;
import com.vkmusic.entity.ResponseVK;
import com.vkmusic.entity.VKUserBean;
import com.vkmusic.service.api.VKApiManager;
import com.vkmusic.service.autentication.CustomAuthenticationManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.vkmusic.datamodel.CommonConstants.PROFILE;
import static com.vkmusic.datamodel.CommonURLs.*;
import static com.vkmusic.datamodel.VKApi.ACCESS_TOKEN_COOKIE;
import static com.vkmusic.datamodel.VKApi.USER_ID_COOKIE;

/**
 * Created by Vadym_Vlasenko on 5/6/2016.
 */
@Controller
public class LoginController {

    @Autowired
    private VKApiManager apiManager;
    @Autowired
    private CustomAuthenticationManager authenticationManager;

    @RequestMapping(value = LOGIN_URL)
    public String login(@CookieValue(value = USER_ID_COOKIE, required = false) String userId,
                        @CookieValue(value = ACCESS_TOKEN_COOKIE, required = false) String token,
                        HttpSession session, HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(token)) {
            ResponseVK responseVK = new ResponseVK(userId, token);
            if (refreshUser(responseVK, session, response)) {
                String referer = request.getHeader(CommonConstants.REFERER);
                referer = StringUtils.isBlank(referer) ? TRACKS : referer;
                return "redirect:" + referer;
            }
        }
        return LOGIN_PAGE;
    }

    @RequestMapping(value = VKLOGIN_URL, method = RequestMethod.GET)
    public String loginWithVK(@RequestParam(required = false) String code,
                              @RequestParam(required = false) String error,
                              HttpSession session,
                              HttpServletResponse response) throws IOException {
        if (StringUtils.isNotBlank(error)) {
            return REDIRECT_ROOT;
        }
        ResponseVK responseVK = apiManager.authentication(code);
        if (refreshUser(responseVK, session, response)) {
            return REDIRECT_MY_TRACKS_URL;
        }
        return REDIRECT_ROOT;
    }

    private boolean refreshUser(ResponseVK responseVK, HttpSession session, HttpServletResponse response) throws IOException {
        boolean result = false;
        VKUserBean vkUserBean = apiManager.getGeneralInfo(responseVK);
        vkUserBean.setResponseVK(responseVK);
        if (vkUserBean != null) {
            session.setAttribute(PROFILE, vkUserBean);
            authenticationManager.authenticateUser(vkUserBean);
            response.addCookie(new Cookie(USER_ID_COOKIE, vkUserBean.getId()));
            response.addCookie(new Cookie(ACCESS_TOKEN_COOKIE, vkUserBean.getResponseVK().getAccess_token()));
            result = true;
        }
        return result;
    }

}
