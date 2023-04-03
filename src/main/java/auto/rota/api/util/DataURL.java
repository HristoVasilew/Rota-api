package auto.rota.api.util;

import auto.rota.api.exception.InvalidImageException;
import org.springframework.util.StringUtils;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static auto.rota.api.constant.GlobalConstants.DATA_URL_PATTERN;

public abstract class DataURL {

    private static final Pattern dataURLPattern = Pattern.compile(DATA_URL_PATTERN);

    public static String[] splitToMediaTypeAndEncodedImage(String dataURL) throws InvalidImageException {

        Matcher m = dataURLPattern.matcher(dataURL);

        if (!m.matches()) {
            throw new InvalidImageException("Data url is invalid");
        }

        String mediaType = m.group(1);

        String encodedImage = m.group(2);

        return new String[]{mediaType, encodedImage};
    }

    public static String binaryImageToBase64(String dataURLMediaType, byte[] binaryImage) {
        if (dataURLMediaType == null && binaryImage == null) {
            return null;
        }

        String encodeToString = Base64.getEncoder().encodeToString(binaryImage);

        return "data:" + dataURLMediaType + ";base64," + encodeToString;
    }

    public static byte[] decodeBase64Image(String encodedImage) throws InvalidImageException {

        if (!StringUtils.hasText(encodedImage)) {
            throw new InvalidImageException("Encoded image cannot be blank");
        }

        try {
            return Base64.getDecoder().decode(encodedImage);
        } catch (IllegalArgumentException exception) {
            throw new InvalidImageException("Encoded image is invalid");
        }
    }

}
