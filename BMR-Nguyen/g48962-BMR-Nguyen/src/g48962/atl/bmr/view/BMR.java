package g48962.atl.bmr.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the main class.
 *
 * @author Michel
 */
public class BMR extends Application {

    /**
     * This is the main method.
     *
     * @param args null.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calcul du BMR");
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(400);
        VBox vbox = new VBoxFinal();
        MenuBar menuBarBMR = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuExit = new Menu("Exit");
        menuBarBMR.getMenus().addAll(menuFile, menuExit);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
