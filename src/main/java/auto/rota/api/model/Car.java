package auto.rota.api.model;

import auto.rota.api.converter.ExtrasJpaConverter;
import auto.rota.api.model.enums.CarType;
import auto.rota.api.model.enums.Extras;
import auto.rota.api.model.enums.FuelType;
import auto.rota.api.validation.anotation.ValidYear;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.EnumSet;

import static auto.rota.api.constant.GlobalConstants.*;

@Data
@Entity()
@Table(name = "cars")
public class Car extends BaseEntity {

    @NotNull
    @Size(min = 6, max = 8, message = REGISTRATION_NUMBER_ERROR_MESSAGE)
    @Pattern(regexp = REGISTRATION_NUMBER_PATTERN, message = REGISTRATION_NUMBER_PATTERN_ERROR_MESSAGE)
    @Column(name = "registration_number", unique = true, nullable = false)
    private String registrationNumber;

    @Size(min = 8, max = 10)
    @Column(name = "car_image_media_type")
    private String carImageMediaType;

    @Size(max = ONE_MEGABYTE)
    @Column(name = "car_image")
    private byte[] carImage;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "car_type", nullable = false)
    private CarType carType;

    @NotNull
    @Size(min = 2, max = 256, message = CAR_MAKE_ERROR_MESSAGE)
    @Pattern(regexp = CAR_MAKE_PATTERN, message = CAR_MAKE_PATTERN_ERROR_MESSAGE)
    @Column(name = "make", nullable = false)
    private String make;

    @NotNull
    @Size(min = 2, max = 256, message = CAR_MODEL_ERROR_MESSAGE)
    @Pattern(regexp = CAR_MODEL_PATTERN, message = CAR_MODEL_PATTERN_ERROR_MESSAGE)
    @Column(name = "model", nullable = false)
    private String model;

    @NotNull
    @ValidYear(message = CAR_YEAR_ERROR_MESSAGE)
    @Column(name = "year", nullable = false)
    private int year;

    @NotNull
    @DecimalMin(value = "0.00", message = PRICE_PER_DAY_ERROR_MESSAGE)
    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @NotNull
    @Range(min = 0, max = 12, message = NUMBER_OF_SEATS_ERROR_MESSAGE)
    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;

    @Convert(converter = ExtrasJpaConverter.class)
    @Column(name = "extras")
    private EnumSet<Extras> extras;
}
