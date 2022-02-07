package ua.com.alevel.dao.impl;

import ua.com.alevel.config.DBFactory;
import ua.com.alevel.dao.CarDao;
import ua.com.alevel.db.CarDB;
import ua.com.alevel.entity.Car;

import java.util.Collection;

public class CarDaoImpl implements CarDao {

    private final CarDB carDB = (CarDB) DBFactory.getInstance().getConfigServiceMap().get(CarDB.class);

    @Override
    public void create(Car entity) {
        carDB.create(entity);
    }

    @Override
    public void update(Car entity) {
        carDB.update(entity);
    }

    @Override
    public void delete(String id) {
        carDB.delete(id);
    }

    @Override
    public Car findById(String id) {
        return carDB.findById(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carDB.findAll();
    }
}
