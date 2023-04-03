package auto.rota.api.service;

import auto.rota.api.dto.CarDto;
import auto.rota.api.exception.*;
import auto.rota.api.model.Car;
import auto.rota.api.repository.CarRepository;
import auto.rota.api.util.DataURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static auto.rota.api.constant.GlobalConstants.ONE_MEGABYTE;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car readByRegistrationNumber(String registrationNumber) throws CarNotFoundException, EmptyRegistrationNumberException {

        if (StringUtils.isEmpty(registrationNumber)) {
            throw new EmptyRegistrationNumberException("Registration number is empty");
        }

        Car car = carRepository.findByRegistrationNumber(registrationNumber);

        if (car == null) {
            throw new CarNotFoundException("Not exist car with that registration number");
        }

        return car;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    @Transactional(rollbackFor = RotaApiException.class)
    public void createCar(CarDto carDto) throws InvalidImageException, RegistrationNumberExistException {

        String carPicture = carDto.getCarPicture();
        String mediaType = null;
        byte[] decodedImage = null;

        if (StringUtils.hasText(carPicture)) {

            String[] mediaTypeAndEncodedImage = DataURL.splitToMediaTypeAndEncodedImage(carPicture);

            mediaType = mediaTypeAndEncodedImage[0];

            if (!mediaType.equalsIgnoreCase("image/jpeg")
                    && !mediaType.equalsIgnoreCase("image/png")) {
                throw new InvalidImageException("Image format must be JPG or PNG");
            }

            decodedImage = DataURL.decodeBase64Image(mediaTypeAndEncodedImage[1]);

            if (decodedImage.length > ONE_MEGABYTE) {
                throw new InvalidImageException("The maximum allowed file size is 1MB");
            }
        }

        if (carRepository.existsByRegistrationNumber(carDto.getRegistrationNumber())) {
            throw new RegistrationNumberExistException("Car with that registration number already exist");
        }

        Car car = new Car();

        car.setRegistrationNumber(carDto.getRegistrationNumber());

        car.setCarImageMediaType(mediaType);
        car.setCarImage(decodedImage);

        car.setCarType(carDto.getCarType());
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setPricePerDay(carDto.getPricePerDay());
        car.setFuelType(carDto.getFuelType());
        car.setNumberOfSeats(carDto.getNumberOfSeats());
        car.setExtras(carDto.getExtras());

        carRepository.saveAndFlush(car);

    }

    public CarDto mapToCarDto(Car car) {
        CarDto carDto = new CarDto();

        String carPicture = DataURL.binaryImageToBase64(car.getCarImageMediaType(), car.getCarImage());

        carDto.setRegistrationNumber(car.getRegistrationNumber());
        carDto.setCarPicture(carPicture);
        carDto.setCarType(car.getCarType());
        carDto.setMake(car.getMake());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());
        carDto.setPricePerDay(car.getPricePerDay());
        carDto.setFuelType(car.getFuelType());
        carDto.setNumberOfSeats(car.getNumberOfSeats());
        carDto.setExtras(car.getExtras());

        return carDto;
    }

    public List<CarDto> mapToCarDtos(List<Car> cars) {

        List<CarDto> carDtoModels = new ArrayList<>();

        for (Car car : cars) {
            CarDto carDto = new CarDto();

            String carPicture = DataURL.binaryImageToBase64(car.getCarImageMediaType(), car.getCarImage());

            carDto.setRegistrationNumber(car.getRegistrationNumber());
            carDto.setCarPicture(carPicture);
            carDto.setCarType(car.getCarType());
            carDto.setMake(car.getMake());
            carDto.setModel(car.getModel());
            carDto.setYear(car.getYear());
            carDto.setPricePerDay(car.getPricePerDay());
            carDto.setFuelType(car.getFuelType());
            carDto.setNumberOfSeats(car.getNumberOfSeats());
            carDto.setExtras(car.getExtras());

            carDtoModels.add(carDto);
        }

        return carDtoModels;

    }

}
