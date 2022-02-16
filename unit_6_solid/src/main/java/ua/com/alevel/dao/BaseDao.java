package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseDao<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String id);
    Optional<ENTITY> findById(String id);
    Collection<ENTITY> findALL();
}
