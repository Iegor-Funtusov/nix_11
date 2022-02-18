package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

public interface BaseService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Integer id);
    E findById(Integer id);
    Collection<E> findAll();
}
