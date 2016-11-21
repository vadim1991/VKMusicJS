package com.vkmusic.controller;

import com.vkmusic.entity.VKUserBean;
import com.vkmusic.entity.vk.FriendParamBean;
import com.vkmusic.service.api.VKApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.vkmusic.datamodel.CommonConstants.PROFILE;

/**
 * Created by Vadym_Vlasenko on 5/18/2016.
 */
@Controller
public class FriendController {

    @Autowired
    private VKApiManager apiManager;

    @RequestMapping(value = "/friends", method = RequestMethod.POST)
    public
    @ResponseBody
    List<VKUserBean> getUserList(HttpSession session, @RequestBody FriendParamBean friendParamBean) throws IOException {
        VKUserBean userBean = (VKUserBean) session.getAttribute(PROFILE);
        List<VKUserBean> friends = new ArrayList<>();
        if (userBean != null) {
            friends = apiManager.getFriends(userBean, friendParamBean);
        }
        return friends;
    }

}
