package Elevator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Andrea on 2016-05-21.
 */
public class FloorList {

    private TreeSet<Floor> floors;

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
        this.floors = new TreeSet<Floor>(new FloorComp());
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

//        TargetFloor targetFloor = new TargetFloor(floor, direction);

        if(!containsFloor(floor, direction)){
            floors.add(floor);
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

        return floors.contains(floor);
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

        Floor nextFloor = null;

        if(currentDirection == Direction.UP){
            nextFloor = floors.ceiling(currentFloor);

            if(nextFloor == null){
                nextFloor = floors.floor(currentFloor);
            }

        } else {
            nextFloor = floors.floor(currentFloor);

            if(nextFloor == null){
                nextFloor = floors.ceiling(currentFloor);
            }
        }
        return nextFloor;
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

        floors.remove(floor);
    }


}

class FloorComp implements Comparator<Floor> {

    @Override
    public int compare(Floor f1, Floor f2) {

        if(f1.getFloorNumber() < f2.getFloorNumber()){
            return -1;
        } else if (f1.getFloorNumber() == f2.getFloorNumber()){
            return 0;
        } else {
            return 1;
        }

    }
}