package Elevator;

public class EventSimulator implements EventSimulatorInterface{

    private int numFloors;
    private ElevatorSystem elevatorSystem;

    /**
     * Simulates an elevator system.
     *
     * @param floors the number of floors
     * @throws IllegalArgumentException if floors is invalid
     */
    public EventSimulator(int floors) throws IllegalArgumentException{

        if( floors <= 1){
            throw new IllegalArgumentException("Need more than 1 floor");
        }
        numFloors = floors;
        elevatorSystem = new ElevatorSystem(numFloors, null);
    }

    /**
     * Checks whether or not the down button on the given floor is lit<br>
     *
     * Preconditions: numFloors is valid<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor to check
     * @return true if the button is lit, false otherwise
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public boolean isDownCallButtonLit(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        return elevatorSystem.floors[floor].downButton.isLightOn();
    }

    /**
     * Checks whether or not the up button on the given floor is lit<br>
     *
     * Preconditions: numFloors is valid<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor to check
     * @return true if the button is lit, false otherwise
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public boolean isUpCallButtonLit(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        return elevatorSystem.floors[floor].upButton.isLightOn();
    }
    /**
     * Checks whether or not the target button corresponding to the given floor
     * is lit in the elevator<br>
     *
     * Preconditions: numFloors is valid<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor to which the button inside the elevator
     * corresponds
     * @return true if the button is lit, false otherwise
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public boolean isTargetButtonLit(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        return elevatorSystem.floors[floor].targetButton.isLightOn();
    }
    /**
     * Check if the elevator door is openDoor<br>
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @return true if the door is openDoor, false otherwise
     */
    public boolean isElevatorDoorOpen(){
        return elevatorSystem.elevator.getDoor().isDoorOpen();
    }
    /**
     * Checks whether or not the door corresponding to the given floor
     * is openDoor<br>
     *
     * Preconditions: numFloors is valid<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor to check
     * @return true if the door is openDoor, false otherwise
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public boolean isFloorDoorOpen(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        return elevatorSystem.floors[floor].getDoor().isDoorOpen();
    }
    /**
     * Check where the elevator is<br>
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     *
     * @return the floor at which the elevator is located
     */
    public int getCurrentElevatorFloor(){
        return elevatorSystem.elevator.getCurrentFloor().getFloorNumber();
    }
    /**
     * Simulates an event where a person on the given floor presses the down
     * button<br>
     *
     * Preconditions: floor is valid<br>
     * Postconditions: The down button has been pressed<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor where the call is to be made
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public void callElevatorDown(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        elevatorSystem.floors[floor].downButton.callElevator();
    }
    /**
     * Simulates an event where a person on the given floor presses the up
     * button<br>
     *
     * Preconditions: floor is valid<br>
     * Postconditions: The down button has been pressed<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor where the call is to be made
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public void callElevatorUp(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException();
        }
        elevatorSystem.floors[floor].upButton.callElevator();
    }
    /**
     * Simulates an event where a person selects a floor from the floor panel
     * inside the elevator<br>
     *
     * Preconditions: floor is valid<br>
     * Postconditions: The down button has been pressed<br>
     * Cleanup: N/A<br>
     *
     * @param floor the floor that is selected
     * @throws IllegalArgumentException if numFloors is invalid
     */
    public void selectFloor(int floor) throws IllegalArgumentException{
        if(floor < 0 || floor >= numFloors){
            throw new IllegalArgumentException("Invalid floor");
        }
        Floor targetFloor = elevatorSystem.floors[floor];
        elevatorSystem.elevator.selectFloor(targetFloor);

    }
    /**
     * Issue a time event. If the elevator is in motion, a tick event
     * causes the elevator to go to the next floor. If the elevator
     * arrives, the doors openDoor and buttons state are changed immediately.
     * If the elevator is stationary, it checks for a floor and moves
     * immediately if there is an outstanding elevator request. Otherwise,
     * this method does nothing.
     */
    public void tick(){

        elevatorSystem.tick();
    }
}
