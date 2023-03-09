package pl.sda.springcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.springcar.model.dto.CarResponse;
import pl.sda.springcar.model.dto.CreateCarRequest;
import pl.sda.springcar.model.dto.UpdateCarResponse;
import pl.sda.springcar.service.CarService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/car")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    // READ
    // http://localhost:8080/car
    @GetMapping()
    public List<CarResponse> getCarList() {
        log.info("Ktos zapytal o liste samochodow.");
        return carService.getAll();
    }

    // CREATE
    // http://localhost:8080/car
    @PostMapping()
    public CarResponse createCar(@RequestBody CreateCarRequest request) {
        log.info("Wywolano dodanie samochodu: {}", request);
        return carService.createCar(request);
    }

    @PatchMapping("/{carId}")
    public UpdateCarResponse updateStudent(@PathVariable Long carId, @RequestBody CreateCarRequest request) {
        log.info("Wywolano aktualizacje samochodu o id: {}, dane: {}", carId, request);
        return carService.update(carId, request);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable Long carId) {
        log.info("Ktos usunal samochod z identyfikatorem {}", carId);
        carService.deleteById(carId);
    }

    @GetMapping("/{carId}")
    public CarResponse getCarById(@PathVariable Long carId) {
        log.info("Ktos zapytal o samochodu z identyfikatorem {}", carId);
        return carService.findById(carId);
    }
}
