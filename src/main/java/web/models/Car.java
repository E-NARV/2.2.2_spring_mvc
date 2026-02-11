package web.models;

import java.util.Objects;

public class Car {
    // Объявляем параметры для машины
    private int id;
    private String model;
    private String brand;

    // Пустой конструктор
    public Car() {

    }

    // Конструктор с параметрами
    public Car(int id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    // Геттеры, сеттеры, переопределение toString, equals и hashcode
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(model, car.model) &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand);
    }
}