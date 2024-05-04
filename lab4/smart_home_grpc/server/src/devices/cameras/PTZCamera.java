package devices.cameras;

import exceptions.InvalidPanException;
import exceptions.InvalidTiltException;
import exceptions.InvalidZoomException;

public class PTZCamera extends RegularCamera {
    private int pan;
    private int tilt;
    private int zoom;

    public PTZCamera(String id) {
        super(id);
        this.pan = 0;
        this.tilt = 0;
        this.zoom = 0;
    }

    public synchronized int getPan() {
        return this.pan;
    }

    public synchronized void setPan(int pan) throws InvalidPanException {
        if (pan < -90 || pan > 90) {
            throw new InvalidPanException("Pan value must be between -90 and 90.");
        }
        this.pan = pan;
    }

    public synchronized int getTilt()  {
        return this.tilt;
    }

    public synchronized void setTilt(int tilt) throws InvalidTiltException {
        if (tilt < -90 || tilt > 90) {
            throw new InvalidTiltException("Tilt value must be between -90 and 90.");
        }
        this.tilt = tilt;
    }

    public synchronized int getZoom() {
        return this.zoom;
    }

    public synchronized void setZoom(int zoom) throws InvalidZoomException {
        if (zoom < 0 || zoom > 100) {
            throw new InvalidZoomException("Zoom value must be between 0 and 100.");
        }
        this.zoom = zoom;
    }
}
