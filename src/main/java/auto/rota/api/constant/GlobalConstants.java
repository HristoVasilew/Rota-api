package auto.rota.api.constant;

public class GlobalConstants {

    public static final int ONE_MEGABYTE = 1024 * 1024;

    public static final int ONE_AND_A_HALF_MEGABYTE = (int) (ONE_MEGABYTE * 1.5);

    public static final String DATA_URL_PATTERN = "^data:(image\\/[a-zA-Z]{3,4});base64,(.*)";

    public static final String REGISTRATION_NUMBER_PATTERN = "^[ABEKMHOPCTYX]{1,2}\\s?[ABEKMHOPCTYX0-9]{4}\\s?[ABEKMHOPCTYX0-9]{1,2}$";

    public static final String CAR_MODEL_PATTERN = "^[A-Za-z0-9]+(?:\\s[A-Za-z0-9]+)*+$";

    public static final String CAR_MAKE_PATTERN = "^[A-Za-z]+(?:\\s[A-Za-z]+)*+$";

    public static final String IMAGE_SIZE_1_5_MB_ERROR_MESSAGE = "Image size is more than 1.5mb";

    public static final String NAME_ERROR_MESSAGE = "Name should be between {min} and {max} characters.";

    public static final String SIZE_EMAIL_ERROR_MESSAGE = "Email should be between {min} and {max} characters.";

    public static final String SIZE_PASSWORD_ERROR_MESSAGE = "Password should be between {min} and {max} characters.";

    public static final String VALIDATION_EMAIL_ERROR_MESSAGE = "Please enter a valid email address.";

    public static final String VALIDATION_PASSWORD_ERROR_MESSAGE = "Please enter a valid password - at least one uppercase, one lowercase letter, and at least one digit.";

    public static final String REGISTRATION_NUMBER_ERROR_MESSAGE = "Registration number should be between {min} and {max} characters.";

    public static final String REGISTRATION_NUMBER_PATTERN_ERROR_MESSAGE = "Registration number should be only digits and uppercase letters.";

    public static final String CAR_MODEL_PATTERN_ERROR_MESSAGE = "Car model should be only digits and letters.";

    public static final String CAR_MAKE_PATTERN_ERROR_MESSAGE = "Brand of the vehicle should be only letters.";

    public static final String CAR_MAKE_ERROR_MESSAGE = "Brand of the vehicle should be between {min} and {max} characters.";

    public static final String CAR_MODEL_ERROR_MESSAGE = "Car Model should be between {min} and {max} characters.";

    public static final String CAR_YEAR_ERROR_MESSAGE = "Year should be between 1886 and current year.";

    public static final String PRICE_PER_DAY_ERROR_MESSAGE = "Price should be minimum 0!";

    public static final String NUMBER_OF_SEATS_ERROR_MESSAGE = "Number of seats should be between {min} and {max}.";

}
