package Elevator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Andrea on 2016-05-21.
 */
public class FloorList {

    private TreeSet<Floor> upFloors;
    private TreeSet<Floor> downFloors;

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

        this.upFloors = new TreeSet<>(new FloorComp());
        this.downFloors = new TreeSet<>(new FloorComp());
    }


    /**
     * Adds the current floor to the floorList
     *
     * <p>
     * Preconditions: a valid floor and direction<br>
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

        if(direction == Direction.UP && !upFloors.contains(floor)){
            upFloors.add(floor);
        } else if (direction == Direction.DOWN && !downFloors.contains(floor)) {
            downFloors.add(floor);
        }

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
     * @return the next floor if there is one, otherwise null
     */
    public Floor nextFloor(Floor currentFloor, Direction currentDirection){

        if(upFloors.isEmpty() && downFloors.isEmpty()){
            return null;
        }

        Floor nextFloor = null;

        if(currentDirection == Direction.UP){


            nextFloor = upFloors.ceiling(currentFloor);

            if(nextFloor == null && !downFloors.isEmpty()){
                nextFloor = downFloors.last();
            }

            if(nextFloor == null){
                nextFloor = upFloors.first();
            }



        } else if (currentDirection == Direction.DOWN) {
            nextFloor = downFloors.floor(currentFloor);

            if(nextFloor == null && !upFloors.isEmpty()){
                nextFloor = upFloors.first();
            }

            if(nextFloor == null){
                nextFloor = downFloors.last();
            }



        } else {
            if(!upFloors.isEmpty()){
                nextFloor = upFloors.floor(currentFloor);
                if(nextFloor == null){
                    nextFloor = upFloors.ceiling(currentFloor);
                }
            }
            else if(!downFloors.isEmpty()){
                nextFloor = downFloors.ceiling(currentFloor);
                if(nextFloor == null){
                    nextFloor = downFloors.floor(currentFloor);
                }
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

        upFloors.remove(floor);
        downFloors.remove(floor);
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