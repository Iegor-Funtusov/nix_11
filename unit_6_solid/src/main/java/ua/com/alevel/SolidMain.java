package ua.com.alevel;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.User;

import java.util.Collection;
import java.util.List;

public class SolidMain {

    public static void main(String[] args) {
        Application.run(SolidMain.class);
//        System.out.println("SolidMain.main");
//        UserDao userDao = new UserDaoImpl();
//        User user = new User();
//        user.setAge(1);
//        user.setFirstName("name1");
//        user.setLastName("name2");
//        userDao.create(user);
//        System.out.println("user = " + user);
//
//        Collection<User> users = userDao.findALL();
//        System.out.println("users = " + users);
//
//        user.setAge(2);
//        userDao.update(user);
//        System.out.println("user = " + user);
//
//        user = userDao.findById(user.getId()).get();
//        System.out.println("user = " + user);
//
//        userDao.delete(user.getId());
//
//        System.out.println(userDao.findALL());
    }
}
