package devices;

import exceptions.DeviceAlreadyOffException;
import exceptions.DeviceAlreadyOnException;

public abstract class Device implements IDevice {
    private String id;
    private Boolean isOn;

    public Device(String id) {
        this.id = id;
        this.isOn = false;
    }

    public synchronized String getId() {
        return this.id;
    }

    public synchronized void turnOn() throws DeviceAlreadyOnException {
        if (this.isOn) {
            throw new DeviceAlreadyOnException("Device is already on");
        }
        this.isOn = true;
    }

    public synchronized void turnOff() throws DeviceAlreadyOffException {
        if (!this.isOn) {
            throw new DeviceAlreadyOffException("Device is already off");
        }
        this.isOn = false;
    }

    public synchronized Boolean isOn() {
        return this.isOn;
    }
}
