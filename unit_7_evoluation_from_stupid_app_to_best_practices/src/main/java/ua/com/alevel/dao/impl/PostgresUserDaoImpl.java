package ua.com.alevel.dao.impl;

import com.nixsolutions.annotations.InitMethod;
import com.nixsolutions.annotations.Service;

import com.nixsolutions.annotations.Value;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;
import com.nixsolutions.util.ResourceUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Service
public class PostgresUserDaoImpl implements UserDao {

    private Connection connection;
    private Statement statement;

    @Value(param = "db.driver")
    private String driver;

    @Value(param = "db.url")
    private String url;

    @Value(param = "db.user")
    private String user;

    @Value(param = "db.password")
    private String password;

    private static final String CREATE_USER = "insert into users values(default,?,?,?)";
    private static final String UPDATE_BY_ID_QUERY = "update users set first_name = ?, last_name = ?, age = ? where id = ?";
    private static final String FIND_ALL_USER_QUERY = "select * from users";
    private static final String FIND_USER_BY_ID_QUERY = "select * from users where id = ";
    private static final String DELETE_USER_BY_ID_QUERY = "delete from users where id = ?";
    private static final String EXISTS_USER_BY_ID_QUERY = "select count(id) as countUsers from users where id = ";

    @InitMethod
    private void init() {
        System.out.println("PostgresUserDaoImpl.init");
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    @Override
    public void create(User entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID_QUERY);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    @Override
    public boolean existsById(Integer id) {
        try {
            ResultSet resultSet = this.statement.executeQuery(EXISTS_USER_BY_ID_QUERY + id);
            while (resultSet.next()) {
                long countUsers = resultSet.getLong("countUsers");
                return countUsers == 1;
            }
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<User> findById(Integer id) {
        try {
            ResultSet resultSet = this.statement.executeQuery(FIND_USER_BY_ID_QUERY + id);
            while (resultSet.next()) {
                return Optional.ofNullable(initUserByResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = this.statement.executeQuery(FIND_ALL_USER_QUERY);
            while (resultSet.next()) {
                users.add(initUserByResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        return users;
    }

    private User initUserByResultSet(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int age = resultSet.getInt("age");
        int id = resultSet.getInt("id");

        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }
}
