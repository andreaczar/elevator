package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class Elevator {

    private Door door = new Door(); // the elevator's door
    private ElevatorSystemInterface system;
    private FloorList floorList = new FloorList(); //the list of floors to be visited
    private Floor currentFloor;
    protected Floor targetFloor;
    private Direction direction;

    /**
     * Creates an Elevator object for the elevator system.
     *
     * Preconditions: Elevator system exists.<br>
     * Postconditions: Elevator object has been initialized.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param system the elevator's elevator system
     * @throws IllegalArgumentException if system is invalid
     */
    public Elevator(ElevatorSystemInterface system) throws IllegalArgumentException{
        if(system == null){
            throw new IllegalArgumentException("Elevator system must be valid.");
        }

        this.system = system;
        this.currentFloor = system.getFloor(0);
    }

    /**
     * Retrieves the door.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @return door the elevator door
     */
    public Door getDoor() {
        return door;
    }

    /**
     * Retrieves the current floor.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @return currentFloor the elevators current floor
     */
    public Floor getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Add the target floor to the elevator's list of floors to be visited.
     *
     * Preconditions: the floor exists<br>
     * Postconditions: floor and direction was added to the floorList<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the target floor to be added
     * @throws IllegalArgumentException if floors is invalid
     */
    public void addFloor(Floor floor)throws IllegalArgumentException{

        if(floor == null){
            throw new IllegalArgumentException("Must be a valid floor.");
        }

        if(floor.getFloorNumber() < currentFloor.getFloorNumber()){
            addFloor(floor, Direction.DOWN);
        }else if(floor.getFloorNumber() > currentFloor.getFloorNumber()){
            addFloor(floor, Direction.UP);
        }
    }

    /**
     * Add the target floor to the elevator's list of floors to be visited.
     *
     * Preconditions: the floor exists<br>
     * Postconditions: the floor and direction were added to the floorList<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the target floor to be added
     * @param direction the floors direction relative to the elevator
     * @throws IllegalArgumentException if floor or direction is invalid
     */
    public void addFloor(Floor floor, Direction direction) throws IllegalArgumentException{
        if(floor == null || direction == null){
            throw new IllegalArgumentException("Floor and Direction must be specified.");
        }

        floorList.addFloor(floor, direction);
    }

    /**
     * Remove the floor from the floorList.
     *
     * Preconditions: Elevator is at the floor.<br>
     * Postconditions: Floor was removed from the floorList.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the floor to be removed
     * @throws IllegalArgumentException if floors is invalid
     */
    public void removeFloor(Floor floor){
        if(floor == null){
            throw new IllegalArgumentException("Must be a valid floor.");
        }
        floorList.remove(floor);
    }
    /**
     * Set the target floor
     * <p>
     * Preconditions: <br>
     * Postconditions: <br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void setTargetFloor(){

        Floor nextTarget = floorList.nextFloor(currentFloor, direction);

        if(nextTarget == null){
            direction = null;
            return;
        }
        // Determine the elevators direction
        if(nextTarget.getFloorNumber() > currentFloor.getFloorNumber()){
            direction = Direction.UP;
        } else if(nextTarget.getFloorNumber() < currentFloor.getFloorNumber()){
            direction = Direction.DOWN;
        }
        targetFloor = nextTarget;
    }
    /**
     * The elevator gets the next floor from the elevator system based on
     * the elevators current direction.
     *
     * <p>
     * Preconditions: the elevator has current direction<br>
     * Postconditions: sets the next floor<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void getNextFloor(){

        Floor nextTargetFloor = floorList.nextFloor(currentFloor, direction);

        if(nextTargetFloor != null){
            if(nextTargetFloor.getFloorNumber() > currentFloor.getFloorNumber()){
                currentFloor = system.getFloor(currentFloor.getFloorNumber()+1);

            } else if(nextTargetFloor.getFloorNumber() < currentFloor.getFloorNumber()){
                currentFloor = system.getFloor(currentFloor.getFloorNumber()-1);
            }
        }
    }
    /**
     * Open the elevator door.
     *
     * <p>
     * Preconditions: Door is closed.<br>
     * Postconditions: Door is open.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void openDoor(){
        door.open();
    }

    /**
     * Close the elevator door.
     *
     * <p>
     * Preconditions: Door is open.<br>
     * Postconditions: Door is closed.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void closeDoor(){
        door.close();
    }

    /**
     * Select a target floor in the elevator.
     *
     * <p>
     * Preconditions: <br>
     * Postconditions: target floor added to floorList, doors are closed <br>
     * Cleanup: N/A<br>
     * <p>
     * @throws IllegalArgumentException if floors is invalid
     */
    public void selectFloor(Floor floor) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Must be a valid floor.");
        }
        floor.callElevator();
        door.close();
        currentFloor.closeDoor();
    }

    /**
     * Clear target floor.
     *
     * Preconditions: N/A
     * Postconditions: target floor is null
     */
    public void clearTargetFloor(){
        targetFloor = null;
    }
}
