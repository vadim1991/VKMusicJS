package com.vkmusic.service.track;

import com.vkmusic.entity.vk.Track;
import com.vkmusic.entity.vk.TrackParam;
import com.vkmusic.repository.generic.GenericRepository;
import com.vkmusic.repository.track.TrackRepository;
import com.vkmusic.service.generic.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by Vadym_Vlasenko on 5/19/2016.
 */
@Service
public class TrackService extends GenericManagerImpl<Track, TrackRepository> {

    @Autowired
    @Qualifier("trackRepository")
    @Override
    public void setRepository(GenericRepository repository) {
        super.setRepository(repository);
    }

    public Page<Track> getTracksByPagination(TrackParam trackParam) {
        return repository.getTracksByPagination(trackParam);
    }

}
