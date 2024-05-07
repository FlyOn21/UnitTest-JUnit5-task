package app.org.example.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureValidatorTest {
    private TemperatureValidator temperatureValidator;

    @BeforeEach
    void setUp() {
        temperatureValidator = new TemperatureValidator();
        temperatureValidator.setRange(-10.0, 35.0);
    }

    @Test
    void isDataValid_returnsTrue_whenTemperatureIsWithinBounds() {
        assertTrue(temperatureValidator.isDataValid(20.0));
    }

    @Test
    void isDataValid_returnsFalse_whenTemperatureIsBelowBounds() {
        assertFalse(temperatureValidator.isDataValid(-11.0));
    }

    @Test
    void isDataValid_returnsFalse_whenTemperatureIsAboveBounds() {
        assertFalse(temperatureValidator.isDataValid(36.0));
    }
}