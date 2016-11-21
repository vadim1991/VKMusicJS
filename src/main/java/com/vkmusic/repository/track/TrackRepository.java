package com.vkmusic.repository.track;

import com.vkmusic.entity.vk.Track;
import com.vkmusic.entity.vk.TrackParam;
import com.vkmusic.repository.generic.GenericRepositoryImpl;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vadym_Vlasenko on 5/19/2016.
 */
@Repository("trackRepository")
public class TrackRepository extends GenericRepositoryImpl<Track> {

    public TrackRepository() {
        setClazz(Track.class);
    }

    public PageImpl<Track> getTracksByPagination(TrackParam trackParam) {
        Query query = new Query();
        int offset = trackParam.getOffset();
        int count = trackParam.getCount();
        int page = offset / count;
        Pageable pageRequest = new PageRequest(page, count);
        query.with(pageRequest);
        List<Track> trackList = getMongoOperations().find(query, getClazz());
        long total = getMongoOperations().count(query, getClazz());
        return new PageImpl<>(trackList, pageRequest, total);
    }

}
