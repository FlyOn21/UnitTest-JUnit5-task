package app.org.example.utils.interfaces;

public interface IDataValidator<T> {
    boolean isDataValid(T data);
    void setRange(T min, T max);

}
