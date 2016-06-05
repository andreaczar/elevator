package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class TargetFloorButton {

    private Floor floor;
    private boolean lightOn = false;

    /**
     * Create the target floor button for the elevator.
     *
     * <p>
     * Preconditions: N/A<br>
     * Postconditions: The target floor button was created.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @param floor the target floor button's floor
     * @throws IllegalArgumentException if floor is invalid
     */
    public TargetFloorButton(Floor floor) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Floor must exist");
        }
        this.floor = floor;
    }

    /**
     * Turn the target floor button light on.
     * <p>
     * Preconditions: the button light is off.<br>
     * Postconditions: the button light is on.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void setLightOn(){
        lightOn = true;
    }

    /**
     * Turn the button light off.
     * <p>
     * Preconditions: the button light is on.<br>
     * Postconditions: the button light is off.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void setLightOff(){
        lightOn = false;
    }

    /**
     * Checks if the buttons light is on.
     *
     * <p>
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     * <p>
     *
     * @return true if the button is lit, false otherwise.
     */
    public boolean isLightOn(){
        return lightOn;
    }

    /**
     * Set the target button light on and notify the floor
     *
     * <p>
     * Preconditions: Elevator at the floor.<br>
     * Postconditions: floor added, button light on<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void activate() {
        setLightOn();
        floor.addFloor();
    }
}
