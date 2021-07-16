package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * This is the table class. It models the composite shape of a table, with different shapes representing food on it.
 */

public class Table {
    //the foods are declared instance variables because they need to be accessible to the Cartoon class.
    private Ellipse _food1;
    private Circle _food2;
    private Polygon _food3;
    private Rectangle _food4;

    /**
     * This is the table constructor. It takes in a pane as a parameter and calls the set up methods defined below.
     */
    public Table(Pane tablePane){
        this.setupTable(tablePane);
        this.setupFood(tablePane);
    }

    /**
     * This method sets up visually the table and adds it to the table pane.
     */
    public void setupTable(Pane tablePane){
        //set up the table body
        Rectangle table = new Rectangle(Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT, Color.SADDLEBROWN);
        table.setY(Constants.TABLE_Y);

        //set up the two table legs
        Rectangle leg1 = new Rectangle(Constants.LEG_WIDTH, Constants.LEG_HEIGHT, Color.DARKBLUE);
        leg1.setY(Constants.TABLEPANE_PREF_HEIGHT - Constants.TABLE_HEIGHT);
        Rectangle leg2 = new Rectangle(Constants.LEG_WIDTH, Constants.LEG_HEIGHT, Color.DARKBLUE);
        leg2.setX(Constants.TABLEPANE_PREF_WIDTH - Constants.LEG_WIDTH);
        leg2.setY(Constants.TABLEPANE_PREF_HEIGHT - Constants.TABLE_HEIGHT);

        //add the components to the table pane
        tablePane.getChildren().addAll(table, leg1, leg2);
    }

    /**
     * This method sets up the shapes representing the food visually and adds them to the table pane.
     */
    public void setupFood(Pane tablePane){
        _food1 = new Ellipse(Constants.FOOD1_X, Constants.FOOD1_Y,
                Constants.FOOD1_RADIUS_X, Constants.FOOD1_RADIUS_Y);
        _food1.setFill(Color.YELLOW);
        _food2 = new Circle( Constants.FOOD2_X, Constants.FOOD2_Y, Constants.FOOD2_RADIUS);
        _food2.setFill(Color.MEDIUMPURPLE);

        //food 3 is a triangle created with the polygon class
        _food3 = new Polygon();
        _food3.getPoints().addAll(new Double[]{Constants.FOOD3_P1, Constants.FOOD3_p2, Constants.FOOD3_P3,
                Constants.FOOD3_P4, Constants.FOOD3_P5, Constants.FOOD3_P6 }); //three vertices
        _food3.setFill(Color.LIGHTBLUE);
        _food4 = new Rectangle(Constants.FOOD4_X, Constants.FOOD4_Y,
                Constants.FOOD4_WIDTH, Constants.FOOD4_HEIGHT);
        _food4.setFill(Color.LIGHTPINK);
        tablePane.getChildren().addAll(_food1, _food2, _food3, _food4); //add the foods to the table pane
    }

    /**
     * These four getter methods are needed in order for the Cartoon class to access the foods and visually change them in its mouse handler class.
     */
    public Ellipse getFood1(){
        return _food1;
    }

    public Circle getFood2(){
        return _food2;
    }

    public Polygon getFood3(){
        return _food3;
    }

    public Rectangle getFood4(){
        return _food4;
    }
}
