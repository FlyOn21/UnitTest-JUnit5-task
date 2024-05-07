package app.org.example.views;

import app.org.example.controllers.DeviceController;

import java.util.Scanner;

public class DeviceView {

    private void displayMenu() {
        String deviceMenu = """
                Menu:
                1) => Set temperature sensor data value
                2) => Exit
                """;
        System.out.println(deviceMenu);
    }

    public void deviceProcessing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Device On ====");
        DeviceController deviceController = new DeviceController();
        while (true) {
            displayMenu();
            System.out.print("Select action: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the temperature :");
                    String result = deviceController.inputTemperature(scanner.nextLine());
                    System.out.println(result);
                    break;
                case "2":
                    System.out.println("==== Device Off ====");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
