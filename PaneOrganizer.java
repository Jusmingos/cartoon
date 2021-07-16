package cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.security.Key;

/**
 * This is the PaneOrganizer class. It creates and organizes the panes.
 * It also has a keyhandler that changes certain visual elements of the cartoon.
 */

public class PaneOrganizer {

    //Declare a cartoon and a root instance variable to be used throughout the program
    private Cartoon _cartoon;
    private BorderPane _root;

    /**
     * This is the pane organizer constructor. It sets up all the panes and associates them with the cartoon class.
     */
    public PaneOrganizer() {
        _root = new BorderPane(); //instantiate the root as a border pane

        //set up 2 rabbit panes
        Pane rabbitPane1 = new Pane();
        rabbitPane1.setPrefSize(Constants.RABBITPANE1_PREF_WIDTH, Constants.RABBITPANE1_PREF_HEIGHT);
        _root.setLeft(rabbitPane1);
        Pane rabbitPane2 = new Pane();
        rabbitPane2.setPrefSize(Constants.RABBITPANE2_PREF_WIDTH, Constants.RABBITPANE2_PREF_HEIGHT);
        _root.setRight(rabbitPane2);

        //set up the table pane
        Pane tablePane = new Pane();
        tablePane.setPrefSize(Constants.TABLEPANE_PREF_WIDTH, Constants.TABLEPANE_PREF_HEIGHT);
        _root.setCenter(tablePane);

        //set up the label pane
        BorderPane labelPane = new BorderPane();
        labelPane.setPrefSize(Constants.LABELPANE_PREF_WIDTH, Constants.LABELPANE_PREF_HEIGHT);
        _root.setTop(labelPane);

        //set up the button pane
        StackPane buttonPane = new StackPane();
        buttonPane.setPrefSize(Constants.BUTTONPANE_PREF_WIDTH, Constants.BUTTONPANE_PREF_HEIGHT);
        _root.setBottom(buttonPane);

        //add a key handler to the root pane so that it applies to the entire program
        _root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());

        //pass in the panes as parameters to the Cartoon constructor
        _cartoon = new Cartoon(rabbitPane1, rabbitPane2, tablePane, labelPane, buttonPane);
    }

    /**
     * This method returns the root pane.
     */
    public BorderPane getRoot(){
        return _root;
    }

    /**
     * This is the private key handler class.
     * It changes the background and the label text color of the cartoon when called.
     */

    private class KeyHandler implements EventHandler<KeyEvent>{

        /**
         * This is the overrided handle method. It changes the text color of the label when called.
         */
        @Override
        public void handle(KeyEvent event) {
            KeyCode keyPressed = event.getCode();
            if (keyPressed == KeyCode.N) {
                _cartoon.getLabel().setTextFill(Color.WHITE);
                this.setupStars(); //call the set up stars method defined below
            }
            event.consume();
        }

        /**
         * This method adds the background image to the program when the key handler is called.
         */
        public void setupStars(){
            Image image1 = new Image("./cartoon/Stars.jpg");
            //set up the background image
            BackgroundImage myBI = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(1.0, 1.0, true,
                            true, false, true));
            //set the background of the entire root pane to be the image
            _root.setBackground(new Background(myBI));
        }
    }
}
