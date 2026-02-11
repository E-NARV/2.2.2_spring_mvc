package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;//

// Объявляем аннотацию для работы с машинами
@Service
public class CarServiceImpl implements CarService {
    // Ссылка на DAO слой для получения списка машин
    private final CarDao carDao;

    // Конструктор с внедрением зависимости CarDao через Spring
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(Integer count) {
        // Получаем полный список машин
        List<Car> cars = carDao.getCars();
        // Если count null, меньше 1 или больше размера списка - возвращаем весь список
        if (count == null || count <= 0 || count >= cars.size()) {
            return cars;
        }
        // Возвращаем столько машин, сколько нужно
        return cars.subList(0, count);
    }
}