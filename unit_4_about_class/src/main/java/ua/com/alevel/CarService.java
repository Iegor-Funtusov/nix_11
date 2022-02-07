package ua.com.alevel;

import ua.com.alevel.dao.CarDao;
import ua.com.alevel.dao.impl.CarDaoImpl;
import ua.com.alevel.entity.Car;

import java.util.Collection;

public class CarService {
    
    CarDao carDao = new CarDaoImpl();

    public void create(Car car) {
        carDao.create(car);
    }

    public void update(Car car) {
        carDao.update(car);
    }

    public void delete(String id) {
        carDao.delete(id);
    }

    public Car findById(String id) {
        return carDao.findById(id);
    }

    public Collection<Car> findAll() {
        return carDao.findAll();
    }
}
