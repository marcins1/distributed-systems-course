package devices.cameras;

import exceptions.DeviceAlreadyOffException;
import exceptions.DeviceAlreadyOnException;

public class NightCamera extends PTZCamera {
    private boolean nightVision;

    public NightCamera(String id) {
        super(id);
        this.nightVision = false;
    }

    public synchronized boolean isNightVisionOn() {
        return this.nightVision;
    }

    public synchronized void setNightVision(boolean nightVision) throws DeviceAlreadyOnException, DeviceAlreadyOffException{
        if (nightVision == this.nightVision) {
            if (nightVision) {
                throw new DeviceAlreadyOnException("Night vision is already on.");
            } else {
                throw new DeviceAlreadyOffException("Night vision is already off.");
            }
        }
        this.nightVision = nightVision;
    }
}
