package app.org.example.model.sensors.interfaces;

import app.org.example.exceptions.DataValueOutOfBoundException;
import app.org.example.exceptions.ParseInputDataStringException;

public interface ISensor<T extends Number> {
    void setValidateRange(T min, T max);
    void setValue(String value) throws DataValueOutOfBoundException, ParseInputDataStringException;
}
