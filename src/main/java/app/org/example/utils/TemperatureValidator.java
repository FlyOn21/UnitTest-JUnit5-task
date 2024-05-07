package app.org.example.utils;

import app.org.example.utils.interfaces.IDataValidator;

public class TemperatureValidator implements IDataValidator<Double> {
    Double min;
    Double max;

    public TemperatureValidator() {
    }
    @Override
    public boolean isDataValid(Double temperature) {
        return temperature >= this.min && temperature <= this.max;
    }

    @Override
    public void setRange(Double min, Double max) {
        this.min = min;
        this.max = max;
    }
}
