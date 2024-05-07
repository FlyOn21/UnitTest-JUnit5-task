package app.org.example.model.sensors;

import app.org.example.exceptions.DataValueOutOfBoundException;
import app.org.example.exceptions.ParseInputDataStringException;
import app.org.example.model.sensors.interfaces.ISensor;
import app.org.example.utils.TemperatureValidator;

public class TemperatureSensor implements ISensor<Double> {
    private final TemperatureValidator validator;

    public TemperatureSensor() {
        this.validator = new TemperatureValidator();
    }

    public void setValidateRange(Double min, Double max) {
        validator.setRange(min, max);
    }

    public void setValue(String valueString) throws ParseInputDataStringException, DataValueOutOfBoundException {
        try {
            Double value = Double.parseDouble(valueString);
            if (!validator.isDataValid(value)) {
                throw new DataValueOutOfBoundException("Temperature is out of bounds");
            }
        } catch (NumberFormatException e) {
            throw new ParseInputDataStringException("Temperature value is not a number");
        }
    }

}
