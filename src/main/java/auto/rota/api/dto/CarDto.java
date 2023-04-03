package auto.rota.api.dto;

import auto.rota.api.model.enums.CarType;
import auto.rota.api.model.enums.Extras;
import auto.rota.api.model.enums.FuelType;
import auto.rota.api.validation.anotation.ValidYear;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.EnumSet;

import static auto.rota.api.constant.GlobalConstants.*;

@Data
public class CarDto {

    @NotNull
    @Size(min = 6, max = 8, message = REGISTRATION_NUMBER_ERROR_MESSAGE)
    @Pattern(regexp = REGISTRATION_NUMBER_PATTERN, message = REGISTRATION_NUMBER_PATTERN_ERROR_MESSAGE)
    private String registrationNumber;

    @Size(max = ONE_AND_A_HALF_MEGABYTE, message = IMAGE_SIZE_1_5_MB_ERROR_MESSAGE)
    private String carPicture;

    @NotNull
    private CarType carType;

    @NotNull
    @Size(min = 2, max = 256, message = CAR_MAKE_ERROR_MESSAGE)
    @Pattern(regexp = CAR_MAKE_PATTERN, message = CAR_MAKE_PATTERN_ERROR_MESSAGE)
    private String make;

    @NotNull
    @Size(min = 2, max = 256, message = CAR_MODEL_ERROR_MESSAGE)
    @Pattern(regexp = CAR_MODEL_PATTERN, message = CAR_MODEL_PATTERN_ERROR_MESSAGE)
    private String model;

    @NotNull
    @ValidYear(message = CAR_YEAR_ERROR_MESSAGE)
    private int year;

    @NotNull
    @DecimalMin(value = "0.00", message = PRICE_PER_DAY_ERROR_MESSAGE)
    private BigDecimal pricePerDay;

    @NotNull
    private FuelType fuelType;

    @NotNull
    @Range(min = 0, max = 12, message = NUMBER_OF_SEATS_ERROR_MESSAGE)
    private int numberOfSeats;

    private EnumSet<Extras> extras;
}
