package ua.com.alevel.entity;

public class Car extends AbstractEntity {

    private String name;
    private CarModel carModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", carModel=" + carModel +
                '}';
    }
}
