package auto.rota.api.controller;

import auto.rota.api.dto.CarDto;
import auto.rota.api.exception.RotaApiException;
import auto.rota.api.model.Car;
import auto.rota.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDto> getAllCars() {
        List<Car> allCars = carService.getAllCars();
        return carService.mapToCarDtos(allCars);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void createCar(
            @Valid @RequestBody CarDto carDto
    ) throws RotaApiException {
        carService.createCar(carDto);
    }

    @GetMapping(value = "/{registrationNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarDto readByRegistrationNumber(
            @PathVariable String registrationNumber
    ) throws RotaApiException {
        Car car = carService.readByRegistrationNumber(registrationNumber);
        return carService.mapToCarDto(car);
    }

}
