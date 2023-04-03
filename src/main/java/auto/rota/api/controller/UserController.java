package auto.rota.api.controller;

import auto.rota.api.dto.CreateUserDto;
import auto.rota.api.exception.RotaApiException;
import auto.rota.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(
            @Valid @RequestBody CreateUserDto userDto
    ) throws RotaApiException {
        userService.createUser(userDto);
    }

}
