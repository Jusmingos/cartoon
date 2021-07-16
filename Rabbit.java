package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

/**
 * This is the abstract rabbit class. It models the composite shape of a rabbit.
 */

public abstract class Rabbit {

    /**
     * These are the body parts of the rabbit.
     * They are instance variables with default access modifier in order to be accessible to rabbit1 and rabbit2.
     */
    Circle _head;
    Circle _eye;
    Ellipse _ear1;
    Ellipse _ear2;
    Circle _body;
    Circle _tail;

    /**
     * This is the Rabbit constructor. It takes a pane as a parameter and passes it into the setupRabbit method.
     */
    public Rabbit(Pane pane){
        this.setupRabbit(pane);
    }

    /**
     * This is the setupRabbit method. It sets up the common features of the two rabbits and adds the components to the pane passed in.
     */
    public void setupRabbit(Pane pane){
        //set up the head
        _head = new Circle(Constants.HEAD_RADIUS);
        _head.setCenterY(Constants.Y_RAD);

        //set up the eye
        _eye = new Circle(Constants.EYE_RADIUS, Color.BLACK);
        _eye.setCenterY(Constants.EYE_Y);

        //set up the body
        _body = new Circle(Constants.BODY_RADIUS);
        _body.setCenterY(Constants.BODY_Y);

        //set up the two ears
        _ear1 = new Ellipse(Constants.EAR_RADIUS_X, Constants.EAR_RADIUS_Y);
        _ear1.setCenterY(Constants.EAR_Y);
        _ear1.setFill(Color.GRAY);
        _ear2 = new Ellipse(Constants.EAR_RADIUS_X, Constants.EAR_RADIUS_Y);
        _ear2.setCenterY(Constants.EAR_Y);
        _ear2.setFill(Color.GRAY);

        //set up the tail
        _tail = new Circle(Constants.TAIL_RADIUS, Color.GRAY);
        _tail.setCenterY(Constants.TAIL_Y);

        //add the elements to the pane
        pane.getChildren().addAll(_head, _eye, _body, _ear1, _ear2, _tail);
    }

    /**
     * This method sets the location of the rabbits. Since the locations of Rabbit1 and Rabbit2 are different, this method is abstract and will be overriden in the subclasses.
     */
    public abstract void setXLoc(double x);

    /**
     * This method returns the X location of the rabbit's head.
     */
    public double getXLoc(){
        return _head.getCenterX();
    }
}
