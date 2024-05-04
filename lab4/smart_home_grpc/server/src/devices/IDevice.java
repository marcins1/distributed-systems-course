package devices;

public interface IDevice {
    public String getId();
    public void turnOn() throws exceptions.DeviceAlreadyOnException;
    public void turnOff() throws exceptions.DeviceAlreadyOffException;
}
