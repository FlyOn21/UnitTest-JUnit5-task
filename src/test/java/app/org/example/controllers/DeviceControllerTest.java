package app.org.example.controllers;

import static org.junit.jupiter.api.Assertions.*;
import app.org.example.config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeviceControllerTest {
    private DeviceController deviceController;

    @BeforeEach
    void setUp() {
        deviceController = new DeviceController();
    }

    @Test
    void inputTemperature_shouldReturnTemperatureIsSet_whenValidTemperatureIsProvided() {
        String result = deviceController.inputTemperature("20");
        assertEquals("Temperature is set", result);
    }

    @Test
    void inputTemperature_shouldReturnTemperatureIsOutOfBound_whenTemperatureIsOutOfBound() {
        String result = deviceController.inputTemperature(String.valueOf(Config.MAX_TEMPERATURE + 1));
        assertEquals("Temperature is out of bounds", result);
    }

    @Test
    void inputTemperature_shouldReturnTemperatureValueIsNotANumber_whenTemperatureIsNotANumber() {
        String result = deviceController.inputTemperature("not a number");
        assertEquals("Temperature value is not a number", result);
    }
}