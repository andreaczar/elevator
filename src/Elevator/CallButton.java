package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class CallButton {

    private Direction direction;
    private CallFloorInterface floor;
    private boolean lightOn;

    /**
     * Creates a CallButton object for each floor.
     * <p>
     * Preconditions: The floor exists <br>
     * Postconditions: The call button has been initialized.<br>
     * Cleanup: N/A<br>
     * <p>
     * @param direction the direction of desired location
     * @param floor the buttons floor number
     * @throws IllegalArgumentException if floor or direction is invalid
     *
     */
    public CallButton(Direction direction, CallFloorInterface floor) throws IllegalArgumentException{
        if(floor == null){
            throw new IllegalArgumentException("Floor must exist.");
        }
        if(direction == null){
            throw new IllegalArgumentException("Call button must have a direction");
        }

        this.direction = direction;
        this.floor = floor;
        this.lightOn = false;
    }

    /**
     * When the call button is pushed, the button's light is turned on and the
     * elevator is called passing it the floor and direction associated
     * with the button.
     * <p>
     * Preconditions: N/A<br>
     * Postconditions: elevator is notified<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void callElevator(){
        setLightOn();
        floor.callElevator(direction);
    }

    /**
     * Turn the call buttons light on.
     * <p>
     * Preconditions: the call button light is off.<br>
     * Postconditions: the call button light is on.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void setLightOn(){
        lightOn = true;
    }

    /**
     * Turn the call buttons light off.
     * <p>
     * Preconditions: the call button light is on.<br>
     * Postconditions: the call button light is off.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void setLightOff(){
        lightOn = false;
    }

    /**
     * Checks if the call buttons light is on.
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
}
