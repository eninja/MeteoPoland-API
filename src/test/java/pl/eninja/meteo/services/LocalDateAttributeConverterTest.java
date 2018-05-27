package pl.eninja.meteo.services;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LocalDateAttributeConverterTest {
    private final LocalDateAttributeConverter converter = new LocalDateAttributeConverter();

    @Test
    public void convertToDatabaseColumnTest() {
        LocalDate locDate = LocalDate.now();
        assertEquals(Date.valueOf(locDate), converter.convertToDatabaseColumn(locDate));
    }

    @Test
    public void convertToEntityAttributeTest() {
        Date sqlDate = new Date(1527285600000L);
        assertEquals(sqlDate.toLocalDate(), converter.convertToEntityAttribute(sqlDate));
    }
}