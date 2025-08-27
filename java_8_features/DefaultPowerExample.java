// Step 1: Define the interface
interface Power {
    // Abstract method
    void turnOn();

    // Default method
    default void showStatus() {
        System.out.println("Power is ON by default method.");
    }
}

// Step 2: Implement the interface
class Device implements Power {
    @Override
    public void turnOn() {
        System.out.println("Device is now ON using abstract method.");
    }
}

// Step 3: Test
public class DefaultPowerExample {
    public static void main(String[] args) {
        Device device = new Device();

        // Call abstract method
        device.turnOn();

        // Call default method
        device.showStatus();
    }
}
