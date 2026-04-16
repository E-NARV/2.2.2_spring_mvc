package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> cars = carDao.getCars();
        if (count == null || count <= 0 || count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}