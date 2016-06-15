package Elevator;

public interface UIControllerInterface {

    public void setCallButtonLit(Direction dir, boolean status, int floor);

    public void setTargetButtonLit(boolean status, int floor);

    public void setDoorOpen(boolean status, int floor);

    public void callUp(int floor);

    public void callDown(int floor);

    public void selectFloor(int floor);
}
