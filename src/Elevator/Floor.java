package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class Floor {

    protected CallButton upButton;
    protected CallButton downButton;
    protected TargetFloorButton targetButton;
    private ElevatorSystem system;
    private int floorNumber;
    private Door door;

    /**
     *
     * Sets up a Floor object in the elevator system. Each floor is assigned a floor number,
     * an up and down button, a door, and it is assigned to the Elevator System.
     *
     * <p>
     * Preconditions: N/A<br>
     * Postconditions: A Floor object has been initialized.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @throws IllegalArgumentException if floor or system is invalid
     */
    public Floor(int floorNumber, ElevatorSystem system) throws IllegalArgumentException{
        if(floorNumber < 0){
            throw new IllegalArgumentException("Must have at least 1 floor.");
        }
        if(system == null){
            throw new IllegalArgumentException("System must be valid.");
        }
        this.floorNumber = floorNumber;
        this.upButton = new CallButton(Direction.UP, this);
        this.downButton = new CallButton(Direction.DOWN, this);
        this.targetButton = new TargetFloorButton(this);
        this.door = new Door();
        this.system = system;
    }

    /**
     * Retrieves the door object.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @return door the floor door
     */
    public Door getDoor() {
        return door;
    }

    /**
     * Retrieves the floor number.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @return floorNumber the floors number
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Call the elevator to the buttons floor.
     *
     * <p>
     * Preconditions: call button pressed on a valid floor.<br>
     * Postconditions: the floor number and direction added to the floorList<br>
     * Cleanup: N/A<br>
     * <p>
     * @throws IllegalArgumentException if direction is invalid
     *
     */
    public void callElevator(Direction direction) throws IllegalArgumentException{
        if(direction == null){
            throw new IllegalArgumentException("Must have a direction to call the elevator.");
        }
        system.elevator.addFloor(this, direction);
    }
    /**
     * Elevator has arrived at target floor.
     *
     * <p>
     * Preconditions: N/A<br>
     * Postconditions: target floor removed from floor list, floor door opened, button lights are off.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void arrived(){
        openDoor();
        lightOff();
        system.elevator.removeFloor(this);
    }
    /**
     * Turn the target floor's button light off inside the elevator.
     * Also turn the current floor's Up and Down button light's off.
     *
     * <p>
     * Preconditions: Elevator on the floor.<br>
     * Postconditions: target, up, down buttons lights are turned off.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void lightOff(){
        targetButton.setLightOff();
        upButton.setLightOff();
        downButton.setLightOff();
    }
    /**
     * Open the elevator and system doors.
     *
     * <p>
     * Preconditions: both doors are closed.<br>
     * Postconditions: both doors are open.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void openDoor(){
        system.openDoor();
        door.open();
    }
    /**
     * Close the elevator and system door.
     *
     * <p>
     * Preconditions: the elevator is stationary, at a floor, and both doors are open<br>
     * Postconditions: both doors are closed<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void closeDoor(){
        system.closeDoor();
        door.close();
    }
    /**
     * Adds the current floor to the floorList
     *
     * <p>
     * Preconditions: a valid floor<br>
     * Postconditions: floor added to the floorList<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void addFloor(){
        system.elevator.addFloor(this);
    }




}
