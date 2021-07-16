package cartoon;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javax.swing.*;

/**
 * This is the Cartoon class. It sets up the details of the visual elements in the program, creates the timeline and contains several event handlers.
 */

public class Cartoon {
    //Declare these as instance variables to be used in the set up methods and the key handlers.
    private Rabbit _rabbit1;
    private Rabbit _rabbit2;
    private Table _table;
    private Label _label;
    private Button _button;

    /**
     * This is the Cartoon class constructor. The panes from the PaneOrganizer class are passed in as parameters.
     */
    public Cartoon(Pane rabbitPane1, Pane rabbitPane2, Pane tablePane, BorderPane labelPane, StackPane buttonPane) {
        //instantiate two rabbits and a table, make sure the rabbit and table class know about the respective panes
        _rabbit1 = new Rabbit1(rabbitPane1);
        _rabbit2 = new Rabbit2(rabbitPane2);
        _table = new Table(tablePane);

        //call the set up methods defined below
        this.setupLabel(labelPane);
        this.setupButtons(buttonPane);
        this.setupTimeline();
    }

    /**
     * This method sets up the visual effect of the label.
     */
    public void setupLabel(BorderPane labelPane){
        _label = new Label();
        _label.setPrefSize(Constants.LABELPANE_PREF_WIDTH, Constants.LABELPANE_PREF_HEIGHT);
        _label.setAlignment(Pos.CENTER);
        _label.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        //give the label a special reflection effect
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        _label.setEffect(reflection);
        labelPane.setCenter(_label); //set the label at the center of the label pane
    }

    /**
     * This method set up the visual effect of the two buttons and a label.
     */
    public void setupButtons(StackPane buttonPane){
        //create a button for the rabbit to eat the food visually
        _button = new Button();
        _button.setMinWidth(Constants.BUTTON_PREF_WIDTH);
        _button.setMinHeight(Constants.BUTTON_PREF_HEIGHT);
        _button.setText("Eat!");
        _button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        buttonPane.setAlignment(_button, Pos.BOTTOM_CENTER);
        _button.setOnMouseClicked(new MouseHandler()); //call the mouse handler everytime this button is clicked

        //create a button that quits the game
        Button quit = new Button();
        quit.setMinWidth(Constants.QUIT_PREF_WIDTH);
        quit.setMinHeight(Constants.QUIT_PREF_HEIGHT);
        quit.setText("Quit");
        quit.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        buttonPane.setAlignment(quit, Pos.BOTTOM_RIGHT);
        quit.setOnMouseClicked(new QuitHandler()); //call the quit handler everytime the quit button is clicked

        /* create a label that tells the user to press n for a special visual effect
           This label is set up in the button pane in order to have it show up visually at the bottom of the stage
         */
        Label label2 = new Label();
        label2.setText("Press n for surprise");
        label2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        buttonPane.setAlignment(label2, Pos.BOTTOM_LEFT);
        buttonPane.getChildren().addAll(_button, quit, label2); //add the three elements to the button pane
    }

    /**
     * This method creates a key frame and sets up the timeline for the cartoon to play infinitely.
     */
    public void setupTimeline(){
        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), new MoveHandler());
        Timeline timeline = new Timeline(kf1);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * This method returns the instance variable label. This allows the Pane Organizer class to get the label and change its text.
     */
    public Label getLabel(){
        return _label;
    }

    /**
     * This is the private move handler class that models the movement of the two rabbits.
     */

    private class MoveHandler implements EventHandler<ActionEvent> {
        private double _distance;

        /**
         * This is the move handler constructor. It sets the distance the rabbits move.
         */
        public MoveHandler(){
            _distance = Constants.DISTANCE_X;
        }

        /**
         * This is the overrided handle method. It moves the two rabbits left and right and changes the text in a label based on the timeline.
         */
        @Override
        public void handle(ActionEvent event) {
            //make the two rabbits move in different locations with the methods in the Rabbit classes
            _rabbit1.setXLoc(_rabbit1.getXLoc() + _distance);
            _rabbit2.setXLoc(_rabbit2.getXLoc() - _distance);
            //move each rabbit in the opposite direction if it is about to move outside its pane
            if (_rabbit1.getXLoc() >= Constants.RABBITPANE1_PREF_WIDTH - (Constants.HEAD_RADIUS)){
                _distance *= -1;
                _label.setText("Time to eat!");
            } else{
                _distance = Constants.DISTANCE_X;
                _label.setText("Let's chat!");
            }
        }
    }

    /**
     * This is the private mouse handler class. It creates a visual effect when a button is clicked.
     */

    private class MouseHandler implements EventHandler<MouseEvent>{

        /**
         * This is the overrided handle method. It makes a food (represented by shapes) visually disappear each time its called.
         */
        @Override
        public void handle(MouseEvent event) {
            /*
               Set the food to be the same color as the table, so as to make it disappear.
               The foods are accessed through getter methods in the Table class.
               When a food is already eaten (disappears), pass on to the next food.
             */
            if(_table.getFood1().getFill() != Color.SADDLEBROWN){
                _table.getFood1().setFill(Color.SADDLEBROWN);
            }else if(_table.getFood2().getFill() != Color.SADDLEBROWN){
                    _table.getFood2().setFill(Color.SADDLEBROWN);
            }else if( _table.getFood3().getFill() != Color.SADDLEBROWN){
                    _table.getFood3().setFill(Color.SADDLEBROWN);
            }else if(_table.getFood4().getFill() != Color.SADDLEBROWN){
                 _table.getFood4().setFill(Color.SADDLEBROWN);
            }else{
                 _button.setText("No more food left :("); //the button displays this message when all foods disappear
            }
        }
    }

    /**
     * This is the private quit handler class. It quits the cartoon when called.
     */

    private class QuitHandler implements EventHandler<MouseEvent>{

        /**
         * This is the overrided handle method. It exits the program.
         */
        @Override
        public void handle(MouseEvent event) {
            System.exit(0);
        }
    }
}
