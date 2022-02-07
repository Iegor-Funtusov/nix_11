package ua.com.alevel.db;

import ua.com.alevel.entity.Car;

import java.util.Collection;

public interface CarDB {

    void create(Car car);
    void update(Car car);
    void delete(String id);
    Car findById(String id);
    Collection<Car> findAll();
}
