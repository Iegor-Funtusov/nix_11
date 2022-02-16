package ua.com.alevel.dao.impl;

import ua.com.alevel.BeanClass;
import ua.com.alevel.MemoryDB;
import ua.com.alevel.PersistenceCommunication;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Optional;

@BeanClass
public class UserDaoImpl implements UserDao {

    private PersistenceCommunication<User, String> persistenceCommunication;

    @Override
    public void create(User entity) {
        persistenceCommunication.create(entity, User.class);
    }

    @Override
    public void update(User entity) {
        try {
            persistenceCommunication.update(entity, User.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        persistenceCommunication.delete(id, User.class);
    }

    @Override
    public Optional<User> findById(String id) {
        return persistenceCommunication.findById(id, User.class);
    }

    @Override
    public Collection<User> findALL() {
        return persistenceCommunication.findAll(User.class);
    }
}
