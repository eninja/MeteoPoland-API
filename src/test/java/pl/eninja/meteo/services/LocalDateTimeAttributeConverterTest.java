package pl.eninja.meteo.services;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeAttributeConverterTest {
    private final LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();

    @Test
    public void convertToDatabaseColumnTest() {
        LocalDateTime locDateTime = LocalDateTime.now();
        assertEquals(Timestamp.valueOf(locDateTime), converter.convertToDatabaseColumn(locDateTime));
    }

    @Test
    public void convertToEntityAttributeTest() {
        Timestamp sqlTimestamp = new Timestamp(1527317382000L);
        assertEquals(sqlTimestamp.toLocalDateTime(), converter.convertToEntityAttribute(sqlTimestamp));
    }
}