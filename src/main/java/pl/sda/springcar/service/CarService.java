package pl.sda.springcar.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.springcar.model.Car;
import pl.sda.springcar.model.dto.CarResponse;
import pl.sda.springcar.model.dto.CreateCarRequest;
import pl.sda.springcar.model.dto.UpdateCarResponse;
import pl.sda.springcar.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAll() {
        return carRepository.findAll()
                .stream().map(car -> mapCarToCarResponse(car))
                .toList();
    }

    private CarResponse mapCarToCarResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getReg(),
                car.getRegistrationDate(),
                car.getDoors(),
                car.getEngineCap()
        );
    }

    public CarResponse createCar(CreateCarRequest request) {
        Car car = Car.builder()
                .reg(request.getRegR())
                .registrationDate(request.getRegistrationDateR())
                .doors(request.getDoorsR())
                .engineCap(request.getEngineCapR())
                .build();

        carRepository.save(car);

        return mapCarToCarResponse(car);
    }

    public UpdateCarResponse update(Long carId, CreateCarRequest request) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono samochodu o id " + carId));
        if (request.getRegR() != null) {
            car.setReg(request.getRegR());
        }

        if (request.getDoorsR() != null) {
            car.setDoors(request.getDoorsR());
        }

        if (request.getEngineCapR() != null) {
            car.setEngineCap(request.getEngineCapR());
        }

        // etap zapisz aktualizowany obiekt, metoda save zwraca wynik po aktualizacji
        car = carRepository.save(car);

        // zwroc response, nie studenta (nie entity!)
        return carToCarResponse(car);

    }

    private UpdateCarResponse carToCarResponse(Car car) {
        return new UpdateCarResponse(
                car.getId(),
                car.getReg(),
                car.getRegistrationDate(),
                car.getDoors(),
                car.getEngineCap()
        );
    }

    public void deleteById(Long carId) {
       carRepository.deleteById(carId);
    }

    public CarResponse findById(Long carId) {
        return carRepository.findById(carId)
                .stream().map(car -> mapCarToCarResponse(car))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono samochodu o id: "+ carId));
    }
}
