package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarService;

// Аннотация, обозначающая, что класс является контроллером
@Controller
// URL, к которому привязаны методы этого контроллера
@RequestMapping("/cars")
public class CarController {
    // Сервис для работы с объектами Car (dependency injection)
    private  final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Обрабатываем GET-запрос на "/cars"
    @GetMapping
    public String cars(@RequestParam(value = "count", required = false) Integer count,
                       Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}