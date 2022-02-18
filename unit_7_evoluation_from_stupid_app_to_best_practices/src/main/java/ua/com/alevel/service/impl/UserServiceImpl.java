package ua.com.alevel.service.impl;

import com.nixsolutions.annotations.Autowired;
import com.nixsolutions.annotations.Service;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User entity) {
        System.out.println("UserServiceImpl.create");
        userDao.create(entity);
    }

    @Override
    public void update(User entity) {
        checkExistsById(entity.getId());
        userDao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        checkExistsById(id);
        userDao.delete(id);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optionalUser = userDao.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public Collection<User> findAll() {
        System.out.println("UserServiceImpl.findAll");
        return userDao.findAll();
    }

    private void checkExistsById(Integer id) {
        if (!userDao.existsById(id)) {
            throw new RuntimeException("user not found");
        }
    }
}
