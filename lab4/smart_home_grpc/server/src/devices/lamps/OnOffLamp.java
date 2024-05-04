package devices.lamps;

public class OnOffLamp extends Lamp {
    public OnOffLamp(String id) {
        super(id);
    }

    public synchronized void turnOn() throws exceptions.DeviceAlreadyOnException {
        super.turnOn();
    }

    public synchronized void turnOff() throws exceptions.DeviceAlreadyOffException {
        super.turnOff();
    }
}
