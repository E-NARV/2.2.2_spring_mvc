package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

// Объявляем аннотацию, чтобы Spring понял, что мы работаем с DAO
@Repository
public class CarDaoImpl implements CarDao {
    // Объявляем стат. переменную для генерации ID
    private static int count;
    // Объявляем список машин, иммитирующий базу данных
    private final List<Car> cars = new ArrayList<>();

    // Создаём конструктор с данными
    public CarDaoImpl() {
        cars.add(new Car(++count, "007", "Zeekr"));
        cars.add(new Car(++count, "M5", "BMW"));
        cars.add(new Car(++count, "Civic", "Honda"));
        cars.add(new Car(++count, "Corolla", "Toyota"));
        cars.add(new Car(++count, "RX", "Exeed"));
    }

    // Переопределяем метод, где возвращаем список всех машин
    @Override
    public List<Car> getCars() {
        return cars;
    }

    // Переопределяем метод, где возвращаем машину по ID
    @Override
    public Car getCarById(int id) {
        // Создаем список данных из списка
        return cars.stream()
                // Оставляем нужную машину с нужным ID
                .filter(car -> car.getId() == id)
                // Берём первый найденный элемент, если есть
                .findAny()
                // Если ничего не найдено, возвращаем null
                .orElse(null);
    }
}