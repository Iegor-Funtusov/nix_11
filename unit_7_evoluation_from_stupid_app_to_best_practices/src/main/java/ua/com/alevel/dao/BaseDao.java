package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseDao<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Integer id);
    boolean existsById(Integer id);
    Optional<E> findById(Integer id);
    Collection<E> findAll();
}
