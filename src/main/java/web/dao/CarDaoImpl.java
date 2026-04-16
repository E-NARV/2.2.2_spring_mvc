package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private static int count;
    private final List<Car> cars = new ArrayList<>();

    public CarDaoImpl() {
        cars.add(new Car(++count, "007", "Zeekr"));
        cars.add(new Car(++count, "M5", "BMW"));
        cars.add(new Car(++count, "Civic", "Honda"));
        cars.add(new Car(++count, "Corolla", "Toyota"));
        cars.add(new Car(++count, "RX", "Exeed"));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findAny()
                .orElse(null);
    }
}