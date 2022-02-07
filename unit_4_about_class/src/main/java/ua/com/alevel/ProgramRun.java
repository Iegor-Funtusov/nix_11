package ua.com.alevel;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.CarModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Set;

public class ProgramRun {

    private static final CarService carService = new CarService();

    public static void run() {
        System.out.println("Program is running...");
        navigation();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line  = reader.readLine();
            while (true) {
                line  = reader.readLine();
                switch (line) {
                    case "1" -> {
                        create(reader);
                    }
                    case "2" -> {

                    }
                    case "3" -> {
                        System.out.println("3");
                    }
                    case "4" -> {
                        findById(reader);
                    }
                    case "5" -> {
                        findAll();
                    }
                    case "0" -> {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private static void navigation() {
        System.out.println("if you want create car, please enter 1");
        System.out.println("if you want update car, please enter 2");
        System.out.println("if you want delete car, please enter 3");
        System.out.println("if you want find car by id, please enter 4");
        System.out.println("if you want find all cars, please enter 5");
    }

    private static void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter a car name:");
        String name = reader.readLine();
        System.out.println("Please enter a car model: BMV, AUDI, OPEL");
        String model = reader.readLine();
        CarModel carModel = CarModel.valueOf(model.toUpperCase());
        Car car = new Car();
        car.setName(name);
        car.setCarModel(carModel);
        carService.create(car);
    }
    private static void update() {}

    private static void delete() {}

    private static void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter a car id:");
        String id = reader.readLine();
        Car car = carService.findById(id);
        System.out.println("car = " + car);
    }


    private static void findAll() {
        System.out.println("All cars:");
        Collection<Car> cars = carService.findAll();
        cars.forEach(System.out::println);
    }
}
