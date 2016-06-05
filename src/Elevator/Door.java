package Elevator;

/**
 * Created by Andrea on 2016-05-21.
 */
public class Door {

    private boolean doorOpen = false;

    /**
     * Open the door.
     *
     * <p>
     * Preconditions: Elevator has stopped at a floor, and door is closed.<br>
     * Postconditions: door was opened.<br>
     * Cleanup: N/A<br>
     * <p>
     */
    public void open(){
        doorOpen = true;
    }

    /**
     * Close the door.
     *
     * <p>
     * Preconditions: Elevator has stopped at a floor, and door is open.<br>
     * Postconditions: door was closed.<br>
     * Cleanup: N/A<br>
     * <p>
     *
     */
    public void close(){
        doorOpen = false;
    }

    /**
     * Check if the door is open.

     * <p>
     * Preconditions: N/A<br>
     * Postconditions: N/A<br>
     * Cleanup: N/A<br>
     * <p>

     * @return true if the door is open, false otherwise.
     */
    public boolean isDoorOpen(){
        return doorOpen;
    }
}
