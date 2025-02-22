package utility;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ZonedDateTime için özel TypeAdapter.
 */
public class ZonedDateTimeAdapter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    @Override
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        // ISO_ZONED_DATE_TIME formatında serileştiriyoruz.
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // ISO_ZONED_DATE_TIME formatında string'den ZonedDateTime nesnesi oluşturuyoruz.
        try {
            return ZonedDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
        } catch (Exception e) {
            throw new JsonParseException("Unable to parse ZonedDateTime: " + json.getAsString(), e);
        }
    }
}