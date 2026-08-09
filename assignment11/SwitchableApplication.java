interface Switchable {

    void turnOn();
}

// Light class
class Light implements Switchable {

    public void turnOn() {
        System.out.println("Light is ON");
    }
}

// Fan class
class Fan implements Switchable {

    public void turnOn() {
        System.out.println("Fan is ON");
    }
}

public class SwitchableApplication {

    public static void main(String[] args) {

        Light light = new Light();

        System.out.println("Light Status:");
        light.turnOn();

        System.out.println();

        Fan fan = new Fan();

        System.out.println("Fan Status:");
        fan.turnOn();
    }
}