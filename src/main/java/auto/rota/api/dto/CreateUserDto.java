package auto.rota.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static auto.rota.api.constant.GlobalConstants.SIZE_PASSWORD_ERROR_MESSAGE;
import static auto.rota.api.constant.GlobalConstants.VALIDATION_PASSWORD_ERROR_MESSAGE;

@Data
public class CreateUserDto extends UserDto {

    @NotNull
    @Size(min = 8, max = 64, message = SIZE_PASSWORD_ERROR_MESSAGE)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,64}$"
            , message = VALIDATION_PASSWORD_ERROR_MESSAGE)
    private String password;

}
