package com.vkmusic.repository.generic;

import java.util.List;

/**
 * Created by Vadym_Vlasenko on 9/25/2015.
 */
public interface GenericRepository<T> {

    T findById(String id);

    List<T> findAll();

    void update(T entity);

    void save(T entity);

    void delete(T entity);

    boolean deleteByID(String id);

    List<T> deleteByIDs(List<String> IDs);

    T findByProperty(String property, Object object);

}
