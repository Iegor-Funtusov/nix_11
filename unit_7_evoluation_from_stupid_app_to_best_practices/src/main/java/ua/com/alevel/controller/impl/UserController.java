package ua.com.alevel.controller.impl;

import com.nixsolutions.annotations.Autowired;
import com.nixsolutions.annotations.Run;
import com.nixsolutions.annotations.Service;

import ua.com.alevel.controller.BaseController;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@Service
public class UserController implements BaseController {

    @Autowired
    private UserService userService;

    @Run
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create user, please enter 1");
        System.out.println("if you want update user, please enter 2");
        System.out.println("if you want delete user, please enter 3");
        System.out.println("if you want findById user, please enter 4");
        System.out.println("if you want findAll user, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("UserController.create");
        try {
            System.out.println("Please, enter your first name");
            String firstName = reader.readLine();
            System.out.println("Please, enter your last name");
            String lastName = reader.readLine();
            System.out.println("Please, enter your age");
            String ageString = reader.readLine();
            Integer age = Integer.parseInt(ageString);

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            userService.create(user);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("UserController.update");
        try {
            System.out.println("Please, enter id");
            Integer id = Integer.parseInt(reader.readLine());
            System.out.println("Please, enter your first name");
            String firstName = reader.readLine();
            System.out.println("Please, enter your last name");
            String lastName = reader.readLine();
            System.out.println("Please, enter your age");
            String ageString = reader.readLine();
            Integer age = Integer.parseInt(ageString);

            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            userService.update(user);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("UserController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Integer idd = Integer.parseInt(id);
            userService.delete(idd);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("UserController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Integer idd = Integer.parseInt(id);
            User user = userService.findById(idd);
            System.out.println("user = " + user);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll() {
        System.out.println("UserController.findAll");
        Collection<User> users = userService.findAll();
        if (users != null && users.size() != 0) {
            for (User user : users) {
                System.out.println("user = " + user);
            }
        } else {
            System.out.println("users empty");
        }
    }
}
