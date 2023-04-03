package auto.rota.api.dto;

import auto.rota.api.validation.anotation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static auto.rota.api.constant.GlobalConstants.*;

@Data
public class UserDto {

    @NotBlank
    @Size(min = 2, max = 256, message = NAME_ERROR_MESSAGE)
    private String name;

    @NotNull
    @Size(min = 6, max = 100, message = SIZE_EMAIL_ERROR_MESSAGE)
    @ValidEmail(message = VALIDATION_EMAIL_ERROR_MESSAGE)
    private String email;

    @Size(max = ONE_AND_A_HALF_MEGABYTE, message = IMAGE_SIZE_1_5_MB_ERROR_MESSAGE)
    private String driverLicence;
}
