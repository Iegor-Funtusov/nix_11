package ua.com.alevel.dao;

import ua.com.alevel.entity.AbstractEntity;

import java.util.Collection;

public abstract interface AbstractDao<E extends AbstractEntity> {

    public abstract void create(E entity);
    void update(E entity);
    void delete(String id);
    E findById(String id);
    Collection<E> findAll();
}
