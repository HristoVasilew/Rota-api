package auto.rota.api.service;

import auto.rota.api.dto.CreateUserDto;
import auto.rota.api.exception.*;
import auto.rota.api.model.User;
import auto.rota.api.repository.UserRepository;
import auto.rota.api.util.DataURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import static auto.rota.api.constant.GlobalConstants.ONE_MEGABYTE;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User readByEmail(String email) throws EmptyEmailException, UserNotFoundException {
        if (StringUtils.isEmpty(email)) {
            throw new EmptyEmailException("Email is empty");
        }

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("Not exist user with that email");
        }

        return user;
    }

    @Transactional(rollbackFor = RotaApiException.class)
    public void createUser(CreateUserDto userDto) throws EmailExistException, InvalidImageException {

        String driverLicence = userDto.getDriverLicence();
        String mediaType = null;
        byte[] decodedImage = null;

        if (StringUtils.hasText(driverLicence)) {

            String[] mediaTypeAndEncodedImage = DataURL.splitToMediaTypeAndEncodedImage(driverLicence);

            mediaType = mediaTypeAndEncodedImage[0];

            if (!mediaType.equalsIgnoreCase("image/jpeg")
                    && !mediaType.equalsIgnoreCase("image/png")) {
                throw new InvalidImageException("Image format must be JPG or PNG");
            }

            decodedImage = DataURL.decodeBase64Image(mediaTypeAndEncodedImage[1]);

            if (decodedImage.length > ONE_MEGABYTE) {
                throw new InvalidImageException("Image max size must be 1mb");
            }
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistException("User with that email already exist");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setDriverLicenceMediaType(mediaType);
        user.setDriverLicenceImage(decodedImage);

        user.setIsAdmin(false);

        userRepository.saveAndFlush(user);
    }
}
