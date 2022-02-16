package ua.com.alevel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class MemoryDB<ENTITY extends PersistenceEntity<ID>, ID> implements PersistenceCommunication<ENTITY, ID>{

    private static MemoryDB instance;
    private final Map<Class<ENTITY>, Collection<ENTITY>> memoryBD = new HashMap<>();

    private MemoryDB() { }

    public static MemoryDB getInstance() {
        if (instance == null) {
            instance = new MemoryDB();
        }
        return instance;
    }

    private Class<ID> getIdClass(ENTITY entity) {
        return (Class<ID>) Arrays.stream(FieldUtils.getAllFields(entity.getClass()))
                .filter(field -> field.getName().equals("id"))
                .findFirst()
                .get()
                .getType();
    }

    @Override
    public void create(ENTITY entity, Class<ENTITY> entityClass) {
        Collection<ENTITY> entities = getDefaultCollectionByEntityClass(entityClass);
        entity.setId(generateId(getIdClass(entity), entities));
        entities.add(entity);
    }

    @Override
    public void update(ENTITY entity, Class<ENTITY> entityClass) throws InvocationTargetException, IllegalAccessException {
        Optional<ENTITY> entityOptional = findById(entity.getId(), entityClass);
        if (entityOptional.isPresent()) {
            BeanUtils.copyProperties(entityOptional.get(), entity);
        }
    }

    @Override
    public void delete(ID id, Class<ENTITY> entityClass) {
        Collection<ENTITY> entities = memoryBD.get(entityClass);
        entities.removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public Optional<ENTITY> findById(ID id, Class<ENTITY> entityClass) {
        Collection<ENTITY> entities = memoryBD.get(entityClass);
        return entities.stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<ENTITY> findAll(Class<ENTITY> entityClass) {
        return getDefaultCollectionByEntityClass(entityClass);
    }

    private ID generateId(Class<ID> idClass, Collection<ENTITY> entities) {
        if (idClass.isAssignableFrom(String.class)) {
            String id = UUID.randomUUID().toString();
            if (entities.stream().anyMatch(entity -> entity.getId().equals(id))) {
                return generateId(idClass, entities);
            }
            return (ID) id;
        }
        return  null;
    }

    private Collection<ENTITY> getDefaultCollectionByEntityClass(Class<ENTITY> entityClass) {
        Collection<ENTITY> entities = memoryBD.get(entityClass);
        if (CollectionUtils.isEmpty(entities)) {
            entities = new ArrayList<>();
            memoryBD.put(entityClass, entities);
        }
        return entities;
    }
}
