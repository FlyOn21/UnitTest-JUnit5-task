package app.org.example.controllers;

import app.org.example.config.Config;
import app.org.example.exceptions.DataValueOutOfBoundException;
import app.org.example.exceptions.ParseInputDataStringException;
import app.org.example.model.divice.Device;
import app.org.example.model.sensors.TemperatureSensor;
import app.org.example.utils.SensorsTypes;


public class DeviceController {
    private final TemperatureSensor tSensor;

    public DeviceController() {
        Device device = new Device();
        this.tSensor = (TemperatureSensor) device.getSensor(SensorsTypes.TEMPERATURE);
        tSensor.setValidateRange(Config.MIN_TEMPERATURE, Config.MAX_TEMPERATURE);
    }


    public String inputTemperature (String temperatureValueStr) {
        try {
            tSensor.setValue(temperatureValueStr);
            return "Temperature is set";
        } catch (DataValueOutOfBoundException e) {
            return "Temperature is out of bounds";
        } catch (ParseInputDataStringException e) {
            return "Temperature value is not a number";
        }
    }
}
