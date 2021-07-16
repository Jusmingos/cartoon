package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * This is the class representing rabbit 2, the rabbit on the right.
 */

public class Rabbit2 extends Rabbit{

    /**
     * This is the rabbit 2 constructor. It takes a pane as its parameter and sets the location and color of rabbit 2.
     */
    public Rabbit2(Pane rabbitPane2){
        super(rabbitPane2); //call the super constructor

        //set up the initial position and color of the body parts
        _head.setCenterX(Constants.X_RAD2);
        _head.setFill(Color.ORANGE);
        _eye.setCenterX(Constants.EYE_X2);
        _body.setCenterX(Constants.BODY_X2);
        _body.setFill(Color.ORANGE);
        _ear1.setCenterX(Constants.EAR3_X);
        _ear2.setCenterX(Constants.EAR4_X);
        _tail.setCenterX(Constants.TAIL_X2);
    }

    /**
     * This is the overrided Rabbit class method. It sets the location of rabbit 2 as it moves along the timeline.
     * This method is called in the move handler in the Cartoon class.
     */
    @Override
    public void setXLoc(double x) {
        _head.setCenterX(x); //set the location of the head as a reference point

        //set the locations of the other body parts relative to the head
        _eye.setCenterX(x - Constants.EYE_OFFSET);
        _body.setCenterX(x + Constants.BODY_OFFSET);
        _ear1.setCenterX(x - Constants.EAR_OFFSET);
        _ear2.setCenterX(x + Constants.EAR_OFFSET);
        _tail.setCenterX(x + Constants.TAIL_OFFSET);
    }
}
