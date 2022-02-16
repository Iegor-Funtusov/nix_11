package ua.com.alevel;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Optional;

public interface PersistenceCommunication<ENTITY extends PersistenceEntity<ID>, ID> {

    void create(ENTITY entity, Class<ENTITY> entityClass);
    void update(ENTITY entity, Class<ENTITY> entityClass) throws InvocationTargetException, IllegalAccessException;
    void delete(ID id, Class<ENTITY> entityClass);
    Optional<ENTITY> findById(ID id, Class<ENTITY> entityClass);
    Collection<ENTITY> findAll(Class<ENTITY> entityClass);
}
