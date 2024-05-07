package app.org.example;

import app.org.example.views.DeviceView;

public class App {
    private final DeviceView startApp = new DeviceView();

    public void run() {
        startApp.deviceProcessing();
    }

    public static void main(String[] args) {
        new App().run();
    }
}