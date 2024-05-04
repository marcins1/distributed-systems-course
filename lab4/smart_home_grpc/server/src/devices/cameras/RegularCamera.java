package devices.cameras;

import exceptions.ResolutionAlreadySetException;
import grpc.camera.CameraResolution;

public class RegularCamera extends Camera {
    private CameraResolution resolution;

    public RegularCamera(String id) {
        super(id);
        this.resolution = CameraResolution.RESOLUTION_1080P;
    }

    public synchronized CameraResolution getResolution() {
        return this.resolution;
    }

    public synchronized void setResolution(CameraResolution resolution) throws ResolutionAlreadySetException {
        if (resolution == this.resolution) {
            throw new ResolutionAlreadySetException("The resolution is already set to " + resolution);
        }
        this.resolution = resolution;
    }
}
