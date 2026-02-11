package web.service;

import web.models.Car;

import java.util.List;

// Слой для работы с машинами
public interface CarService {
    // Получаем список машин
    List<Car> getCars(Integer count);
}