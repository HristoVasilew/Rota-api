package auto.rota.api.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum Extras {

    AC("AC"),
    NAVIGATION("Navigation"),
    AUTOPILOT("Autopilot"),
    ANDROID_AUTO("Android auto"),
    APPLE_CARPLAY("Apple carplay"),
    CHILD_SEAT("Child seat");

    private final String jsonName;

    Extras(String jsonName) {
        this.jsonName = jsonName;
    }

    @JsonValue
    public String getJsonName() {
        return jsonName;
    }

}
