package ua.com.alevel.db;

import ua.com.alevel.entity.Car;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CarSetDb implements CarDB {

    private final Set<Car> cars = new HashSet<>();

    private static CarSetDb instance;

    private CarSetDb() {
        System.out.println("CarSetDb.CarSetDb");
    }

    public static CarSetDb getInstance() {
        if (instance == null) {
            instance = new CarSetDb();
        }
        return instance;
    }

    public void create(Car car) {
        car.setId(generateId());
        cars.add(car);
    }

    public void update(Car car) {
        Car current = findById(car.getId());
        current.setCarModel(car.getCarModel());
        current.setName(car.getName());
    }

    public void delete(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public Car findById(String id) {
        return cars
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .get();
    }

    public Set<Car> findAll() {
        return cars;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (cars.stream().anyMatch(car -> car.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
