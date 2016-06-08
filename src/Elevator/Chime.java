package Elevator;

import java.awt.*;

/**
 * Created by Andrea on 2016-05-21.
 */
public class Chime {

    /**
     * Play the chime.
     *
     * Preconditions: N/A <br>
     * Postconditions: chime has played and stopped.<br>
     * Cleanup: N/A<br>
     */
    public void play(){
        Toolkit.getDefaultToolkit().beep();
    }


}
