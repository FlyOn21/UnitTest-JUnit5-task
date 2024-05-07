package app.org.example.model.sensors;

import static org.junit.jupiter.api.Assertions.*;
import app.org.example.exceptions.DataValueOutOfBoundException;
import app.org.example.exceptions.ParseInputDataStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureSensorTest {
    private TemperatureSensor temperatureSensor;

    @BeforeEach
    void setUp() {
        temperatureSensor = new TemperatureSensor();
        temperatureSensor.setValidateRange(-10.0, 35.0);
    }

    @Test
    void setValue_shouldThrowDataValueOutOfBoundException_whenTemperatureIsOutOfBound() {
        assertThrows(DataValueOutOfBoundException.class, () -> temperatureSensor.setValue("36"));
    }

    @Test
    void setValue_shouldThrowParseInputDataStringException_whenTemperatureIsNotANumber() {
        assertThrows(ParseInputDataStringException.class, () -> temperatureSensor.setValue("not a number"));
    }

    @Test
    void setValue_shouldNotThrowException_whenTemperatureIsWithinBounds() throws DataValueOutOfBoundException, ParseInputDataStringException {
        temperatureSensor.setValue("20");
    }
}