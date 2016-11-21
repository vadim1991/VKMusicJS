package com.vkmusic.service.generic;

import java.util.List;

/**
 * Created by Vadym_Vlasenko on 9/30/2015.
 */
public interface GenericManager<T> {

    T findById(String id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    boolean deleteByID(String id);

    List<T> deleteByIDs(List<String> IDs);


    T findByProperty(String property, Object object);

}
