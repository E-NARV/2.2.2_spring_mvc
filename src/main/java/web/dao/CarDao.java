package web.dao;

import web.models.Car;

import java.util.List;

// DAO (Data Access Object), для работы с объектами Car
public interface CarDao {
    // Получаем список всех машин
    List<Car> getCars();
    // Получаем машину по ID
    Car getCarById(int id);
}