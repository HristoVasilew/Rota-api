package auto.rota.api.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarType {

    PASSENGER("Passenger"),
    CARGO("Cargo"),
    ELECTRIC("Electric");

    private final String jsonName;

    CarType(String jsonName) {
        this.jsonName = jsonName;
    }

    @JsonValue
    public String getJsonName() {
        return jsonName;
    }
}
