package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * This is the class representing rabbit1, the rabbit on the left.
 */

public class Rabbit1 extends Rabbit{

    /**
     * This is the rabbit1 constructor. It takes a pane as its parameter and sets the location and color of rabbit 1.
     */
    public Rabbit1(Pane rabbitPane1){
        super(rabbitPane1); //call the super constructor

        //set up the initial position and color of the body parts
        _head.setCenterX(Constants.X_RAD1);
        _head.setFill(Color.PINK);
        _eye.setCenterX(Constants.EYE_X1);
        _body.setCenterX(Constants.BODY_X1);
        _body.setFill(Color.PINK);
        _ear1.setCenterX(Constants.EAR1_X);
        _ear2.setCenterX(Constants.EAR2_X);
        _tail.setCenterX(Constants.TAIL_X1);
    }

    /**
     * This is the overrided Rabbit class method. It sets the location of rabbit 1 as it moves along the timeline.
     * This method is called in the move handler in the Cartoon class.
     */
    @Override
    public void setXLoc(double x) {
        _head.setCenterX(x); //set the location of the head as a reference point

        //set the locations of the other body parts relative to the head
        _eye.setCenterX(x + Constants.EYE_OFFSET);
        _body.setCenterX(x - Constants.BODY_OFFSET);
        _ear1.setCenterX(x + Constants.EAR_OFFSET);
        _ear2.setCenterX(x - Constants.EAR_OFFSET);
        _tail.setCenterX(x - Constants.TAIL_OFFSET);
    }
}
