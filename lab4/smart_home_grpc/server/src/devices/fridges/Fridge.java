package devices.fridges;

import devices.Device;
import exceptions.DeviceAlreadyOffException;
import exceptions.DeviceAlreadyOnException;
import exceptions.InvalidFreezerTemperatureException;
import exceptions.InvalidFridgeTemperatureException;

public class Fridge extends Device {
    private int fridgeTemperature;
    private int freezerTemperature;
    private Boolean isFreezerOn;

    public Fridge(String id) {
        super(id);
        this.fridgeTemperature = 3;
        this.freezerTemperature = -18;
        this.isFreezerOn = false;
    }

    public synchronized int getFridgeTemperature() {
        return this.fridgeTemperature;
    }

    public synchronized int getFreezerTemperature() {
        return this.freezerTemperature;
    }

    public synchronized Boolean isFreezerOn() {
        return this.isFreezerOn;
    }

    public synchronized void setFridgeTemperature(int temperature) throws InvalidFridgeTemperatureException {
        if (temperature < 2 || temperature > 8) {
            throw new InvalidFridgeTemperatureException("Fridge temperature must be between 2 and 8.");
        }
        this.fridgeTemperature = temperature;
    }

    public synchronized void setFreezerTemperature(int temperature) throws InvalidFreezerTemperatureException {
        if (temperature > 0 || temperature < -18) {
            throw new InvalidFreezerTemperatureException("Freezer temperature must be between -18 and 0.");
        }
        this.freezerTemperature = temperature;
    }

    public synchronized void turnFreezerOn() throws DeviceAlreadyOnException {
        if (isFreezerOn) {
            throw new DeviceAlreadyOnException("Freezer is already on.");
        }
        this.isFreezerOn = true;
    }

    public synchronized void turnFreezerOff() throws DeviceAlreadyOffException{
        if (!isFreezerOn) {
            throw new DeviceAlreadyOffException("Freezer is already off.");
        }
        this.isFreezerOn = false;
    }
}
