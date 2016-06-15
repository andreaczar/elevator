package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class ElevatorSystem implements ElevatorSystemInterface{

    private Chime chime = new Chime();
    protected Elevator elevator;
    protected Floor[] floors;
    UIController controller;

    /**
     * Creates an Elevator system object. Instantiates the Floor[] and
     * initializes.
     *
     * Preconditions: numFloors is valid<br>
     * Postconditions: an elevator system object is initialized.<br>
     * Cleanup: N/A<br>
     *
     * @param numFloors the number of floors in the elevator system
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public ElevatorSystem(int numFloors, UIController controller) throws IllegalArgumentException{
        if( numFloors <= 1){
            throw new IllegalArgumentException("Need more than 1 floor");
        }
        this.controller = controller;
        this.floors = new Floor[numFloors];

        for(int i = 0; i < numFloors; i++){
            floors[i] = new Floor(i, this, controller);
        }
        this.elevator = new Elevator(this);
    }

    /**
     * Notifies the elevator to get the next floor from the floorlist.
     *
     * <p>
     * Preconditions: floors in floorlist<br>
     * Postconditions: next floor is found<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void getNextFloor(){
        elevator.closeDoor();
        elevator.getCurrentFloor().closeDoor();

        if(controller != null){
            controller.setDoorOpen(false, elevator.getCurrentFloor().getFloorNumber());
        }
        elevator.getNextFloor();
    }

    /**
     * Notifiy the elevator to open its door.     *
     *
     * <p>
     * Preconditions: arrived at next floor<br>
     * Postconditions: door open<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void openDoor(){
        elevator.openDoor();

        if(controller != null){
            controller.setDoorOpen(true, elevator.getCurrentFloor().getFloorNumber());
        }
    }

    /**
     * Tell the elevator to close its door.
     *
     * <p>
     * Preconditions: elevator door is open.<br>
     * Postconditions: door closed.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void closeDoor(){
        elevator.closeDoor();
    }

    /**
     * Upon arrival at floor, perform the following actions:
     * open elevator door, inform floor of arrival, play chime, and set target floor to null.
     *
     * <p>
     * Preconditions: arrived at a valid floor.<br>
     * Postconditions: elevator door is open, chime was played, floor was alerted.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the floor
     * @throws IllegalArgumentException if floor is invalid
     */
    public void arrivedAtFloor(Floor floor) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Must be a valid floor.");
        }

        elevator.openDoor();
        floor.arrived();
        chime.play();
        elevator.clearTargetFloor();

    }

    /**
     * Instructs the elevator to add a floor to visit, direction with respect
     * to the elevators direction.
     *
     * Preconditions: N/A
     * Postconditions: floor is in list of floors to visit
     *
     * @param floor the floor to be added
     */
    public void addFloor(Floor floor){
        elevator.addFloor(floor);
    }

    /**
     * Instructs the elevator to add a floor to visit, direction explicitly specified.
     *
     * Preconditions: N/A
     * Postconditions: floor is in list of floors to visit
     *
     * @param floor the floor to be added
     * @param direction the direction of travel upon departing floor
     */
    public void addFloor(Floor floor, Direction direction){
        elevator.addFloor(floor, direction);
    }

    /**
     * Instructs the elevator to remove the floor from the list of floors to visit.
     *
     * Preconditions: the floor is in the list
     * Postconditions: floor is removed from the list
     *
     * @param floor the floor to be removed
     */
    public void removeFloor(Floor floor) {
        elevator.removeFloor(floor);
    }

    /**
     * Retrieves the floor.
     *
     * Preconditions: N/A
     * Postconditions: N/A
     *
     * @param floorNumber the 0-based index of the floor
     * @return the floor at the specified index
     */
    public Floor getFloor(int floorNumber){
        return floors[floorNumber];
    }

    public void tick() {
        elevator.setTargetFloor();

        getNextFloor();

        if(elevator.targetFloor == elevator.getCurrentFloor()){
            arrivedAtFloor(elevator.targetFloor);
        }
    }
}
