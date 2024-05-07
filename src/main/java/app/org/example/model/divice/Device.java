package app.org.example.model.divice;


import app.org.example.model.sensors.TemperatureSensor;
import app.org.example.model.sensors.interfaces.ISensor;
import app.org.example.utils.SensorsTypes;

import java.util.HashMap;

public class Device {
    HashMap<SensorsTypes, ISensor<?> > sensors;

    public Device() {
        sensors = new HashMap<>();
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        sensors.put(SensorsTypes.TEMPERATURE, temperatureSensor);
    }

    public ISensor<?> getSensor(SensorsTypes type) {
        return sensors.get(type);
    }

}
