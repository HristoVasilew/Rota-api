package auto.rota.api.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FuelType {

    GASOLINE("Gasoline"),
    DIESEL("Diesel"),
    LPG("LPG"),
    ELECTRIC("Electric");

    private final String jsonName;

    FuelType(String jsonName) {
        this.jsonName = jsonName;
    }

    @JsonValue
    public String getJsonName() {
        return jsonName;
    }
}
