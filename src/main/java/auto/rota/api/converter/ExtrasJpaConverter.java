package auto.rota.api.converter;

import auto.rota.api.model.enums.Extras;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.stream.Collectors;

@Converter
public class ExtrasJpaConverter implements AttributeConverter<EnumSet<Extras>, String> {

    @Override
    public String convertToDatabaseColumn(EnumSet<Extras> extras) {
        if (extras != null && !extras.isEmpty()) {
            return extras
                    .stream()
                    .map(Extras::name)
                    .collect(Collectors.joining(","));
        }

        return null;
    }

    @Override
    public EnumSet<Extras> convertToEntityAttribute(String dbSetExtras) {

        if (dbSetExtras == null || StringUtils.isEmpty(StringUtils.trimAllWhitespace(dbSetExtras))) {
            return EnumSet.noneOf(Extras.class);
        }


        EnumSet<Extras> extrasSet = EnumSet.noneOf(Extras.class);

        String[] persistenceExtras = dbSetExtras.split(",");

        for (String currentExtra : persistenceExtras) {

            currentExtra = currentExtra.trim();

            if (!currentExtra.isEmpty()) {

                extrasSet.add(Extras.valueOf(currentExtra));

            }

        }

        return extrasSet;
    }
}
