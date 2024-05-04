package devices.lamps;

import exceptions.DeviceAlreadyOnException;
import exceptions.InvalidBrightnessException;

public class BrightnessLamp extends Lamp {
    private Integer brightness;

    public BrightnessLamp(String id) {
        super(id);
        this.brightness = 0;
    }

    public synchronized Integer getBrightness() {
        return this.brightness;
    }

    public synchronized void setBrightness(Integer brightness) throws exceptions.DeviceAlreadyOffException, DeviceAlreadyOnException, InvalidBrightnessException{
        if (brightness < 0 || brightness > 100) {
            throw new InvalidBrightnessException("Brightness must be between 0 and 100");
        }
        this.brightness = brightness;
        if (brightness > 0) {
            if (!super.isOn()) {
                super.turnOn();
            }
        } else {
            super.turnOff();
        }
    }
}
