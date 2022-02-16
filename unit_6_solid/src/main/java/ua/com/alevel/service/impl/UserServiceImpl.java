package ua.com.alevel.service.impl;

import ua.com.alevel.BeanClass;
import ua.com.alevel.InjectBean;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

@BeanClass
public class UserServiceImpl implements UserService {

    @InjectBean
    private UserDao userDao;
    private String some;

    public void create(User user) {}
}
