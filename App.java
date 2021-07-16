package cartoon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Cartoon App class. It sets up and displays the stage.
 *
 */

public class App extends Application {
    /**
     * This is the start method. It sets up the stage of the cartoon.
     */
    @Override
    public void start(Stage stage) {
        //instantiate a top level PaneOrganizer object
        PaneOrganizer organizer = new PaneOrganizer();
        stage.setTitle("The Happy Life of Two Rabbits");
        Scene scene = new Scene(organizer.getRoot());
        stage.setScene(scene);
        stage.show();
    }

    /*
    * This is the main line.
    */
    public static void main(String[] argv) {
        launch(argv);
    }
}
