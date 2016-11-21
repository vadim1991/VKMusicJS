package com.vkmusic.controller;

import com.vkmusic.entity.VKUserBean;
import com.vkmusic.entity.vk.AudioSearchBean;
import com.vkmusic.entity.vk.Track;
import com.vkmusic.entity.vk.TrackParam;
import com.vkmusic.entity.vk.TrackRequest;
import com.vkmusic.service.api.VKApiManager;
import com.vkmusic.service.track.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.vkmusic.datamodel.CommonConstants.PROFILE;

/**
 * Created by Vadym_Vlasenko on 5/9/2016.
 */
@Controller
public class AudioController {

    @Autowired
    private VKApiManager vkApiManager;
    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/tracks", method = RequestMethod.POST)
    public @ResponseBody List<Track> getTracks(HttpSession session, @RequestBody TrackParam trackParam) throws IOException {
        VKUserBean user = (VKUserBean) session.getAttribute(PROFILE);
        List<Track> trackList = new ArrayList<>();
        if (user != null) {
            trackList = vkApiManager.getAudio(user, trackParam);
        }
        return trackList;
    }

    @RequestMapping(value = "/search")
    public String search() {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<Track> searchTracks(HttpSession session, @RequestBody AudioSearchBean searchParam) throws IOException {
        VKUserBean user = (VKUserBean) session.getAttribute(PROFILE);
        List<Track> trackList = new ArrayList<>();
        if (user!= null) {
            trackList = vkApiManager.searchAudio(user, searchParam);
        }
        return trackList;
    }

    @RequestMapping(value = "/shared-tracks", method = RequestMethod.POST)
    public @ResponseBody List<Track> getSharedTracks(@RequestBody TrackParam trackParam) {
        Page<Track> trackPage = trackService.getTracksByPagination(trackParam);
        return trackPage.getContent();
    }

    @RequestMapping(value = "/shared")
    public String getSharedTracks() {
        return "shared-tracks";
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public @ResponseBody String shareTrack(@RequestBody String id, HttpSession session) throws IOException {
        VKUserBean user = (VKUserBean) session.getAttribute(PROFILE);
        List<Track> trackList;
        if (user!= null) {
            trackList = vkApiManager.getAudiosByID(user, id);
            trackService.save(trackList.get(0));
        }
        return "ok";
    }

    @RequestMapping(value = "/tracks/add", method = RequestMethod.POST)
    public @ResponseBody String addTrack(@RequestBody TrackRequest trackRequest, HttpSession session) throws IOException {
        VKUserBean user = (VKUserBean) session.getAttribute(PROFILE);
        return vkApiManager.addTrackToProfile(user, trackRequest);
    }

    @RequestMapping(value = "/tracks/delete", method = RequestMethod.POST)
    public @ResponseBody String deleteTrack(@RequestBody TrackRequest trackRequest, HttpSession session) throws IOException {
        VKUserBean user = (VKUserBean) session.getAttribute(PROFILE);
        return vkApiManager.deleteTrackFromProfile(user, trackRequest);
    }

}
