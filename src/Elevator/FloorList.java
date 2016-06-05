package Elevator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class FloorList {

    private ArrayList<TargetFloor> floors;

    /**
     * Floorlist is instantiated.
     *
     * <p>
     * Preconditions: <br>
     * Postconditions: floorlist is instantiated.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public FloorList(){
        this.floors = new ArrayList<TargetFloor>();
    }

    /**
     *
     * Adds the current floor to the floorList
     *
     * <p>
     * Preconditions: a valid floor<br>
     * Postconditions: floor added to the floorList<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the floor to be added
     * @param direction the direction of the floor
     * @throws IllegalArgumentException if floor or direction is invalid
     */
    public void addFloor(Floor floor, Direction direction) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Floor must exist.");
        }
        if(direction == null){
            throw new IllegalArgumentException("Call button must have a direction");
        }

        TargetFloor targetFloor = new TargetFloor(floor, direction);

        if(!containsFloor(floor, direction)){
            floors.add(targetFloor);
        }
    }

    /**
     * Checks if the target floor is already contained in the floorList.
     *
     * Preconditions: <br>
     * Postconditions: <br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the target floor
     * @param direction the direction
     * @return true if the target floor is in the list of floors, false otherwise
     * @throws IllegalArgumentException if floor or direction is invalid
     */
    public boolean containsFloor(Floor floor, Direction direction) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Floor must exist.");
        }
        if(direction == null){
            throw new IllegalArgumentException("Call button must have a direction");
        }


        for (TargetFloor targetFloor: floors) {
            if(targetFloor.getFloor().equals(floor) && targetFloor.getDirection().equals(direction)){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the next floor for the elevator to visit based on the elevator
     * location and direction.
     *
     * Preconditions: <br>
     * Postconditions: the next floor is determined<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param currentFloor the current floor the elevator is on
     * @param currentDirection the direction the elevator is travelling
     * @return the next floor, otherwise null
     */
    public Floor nextFloor(Floor currentFloor, Direction currentDirection){

        if(floors.isEmpty()){
            return null;
        }

        return floors.get(0).getFloor();
    }

    /**
     * Remove the floor from the floorList.
     *
     * Preconditions: elevator is at floor<br>
     * Postconditions: the floor is removed from the floor list<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the floor to be removed
     * @ throws IllegalArgumentException if floor is invalid.
     */
    public void remove(Floor floor)throws IllegalArgumentException{

        if(floor == null){
            throw new IllegalArgumentException("Floor must be valid");
        }

        Iterator<TargetFloor> it = floors.iterator();
        while (it.hasNext()) {
            if (it.next().getFloor().equals(floor)) {
                it.remove();
            }
        }
    }


}
