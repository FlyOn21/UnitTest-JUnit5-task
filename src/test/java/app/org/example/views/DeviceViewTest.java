package app.org.example.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class DeviceViewTest {
    private DeviceView deviceView;
    private final InputStream sysInBackup = System.in; // backup System.in to restore it later

    @BeforeEach
    void setUp() {
        deviceView = new DeviceView();
    }

    @Test
    void deviceProcessing_shouldReturnTemperatureSet_whenValidTemperatureIsProvided() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n20\n2\n".getBytes());
        System.setIn(in);

        deviceView.deviceProcessing();

        System.setIn(sysInBackup);
    }

    @Test
    void deviceProcessing_shouldReturnInvalidChoice_whenInvalidChoiceIsProvided() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n".getBytes());
        System.setIn(in);

        deviceView.deviceProcessing();

        System.setIn(sysInBackup);
    }

    @Test
    void deviceProcessing_shouldReturnDeviceOff_whenChoiceIsExit() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);

        deviceView.deviceProcessing();

        System.setIn(sysInBackup);
    }
}