package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class TargetFloor {
    private Floor floor;
    private Direction direction;

    /**
     * Creates a target floor object.
     *
     * Preconditions: N/A<br>
     * Postconditions: target floor was created.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the floor
     * @param direction the direction
     * @throws IllegalArgumentException if floor is invalid or a direction is not valid
     */
    public TargetFloor(Floor floor, Direction direction)throws IllegalArgumentException{

        if(floor == null){
            throw new IllegalArgumentException("Floor must be valid");
        }
        if(direction != Direction.UP && direction != Direction.DOWN){
            throw new IllegalArgumentException("Direction must be set");
        }

        this.floor = floor;
        this.direction = direction;
    }

    /**
     * Gets the target floor.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A <br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @return the target floor
     */
    public Floor getFloor() {
        return floor;
    }

    /**
     * Sets the target floor.
     *
     * Preconditions: N/A<br>
     * Postconditions: the target floor has been set.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the target floor
     * @throws IllegalArgumentException if floor is not valid
     */
    public void setFloor(Floor floor) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Floor must exist.");
        }

        this.floor = floor;
    }

    /**
     * Gets the target floors direction.
     *
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @return the target floors direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     *  Sets the target floors direction.
     *
     * Preconditions: N/A<br>
     * Postconditions: the direction is set.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param direction the target floors direction
     * @throws IllegalArgumentException if floor is invalid or a direction is not valid
     */
    public void setDirection(Direction direction) throws IllegalArgumentException {
        if(floor == null){
            throw new IllegalArgumentException("Floor must be valid");
        }
        if(direction != Direction.UP && direction != Direction.DOWN){
            throw new IllegalArgumentException("Direction must be valid");
        }
        this.direction = direction;
    }
}
