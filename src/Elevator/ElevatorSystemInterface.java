package Elevator;

/**
 * Created by Andrea on 2016-06-07.
 */
public interface ElevatorSystemInterface {

    void addFloor(Floor floor);
    void addFloor(Floor floor, Direction direction);
    void removeFloor(Floor floor);
    void openDoor();
    void closeDoor();
    Floor getFloor(int floorNumber);
}
