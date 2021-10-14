package g48962.atl.bmr.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * This is the class MenuBar.BMR
 *
 * @author Michel
 */
public class MenuBarBMR extends MenuBar {

    /**
     * This is the constructor of MenuBarBMR.
     */
    public MenuBarBMR() {

        Menu menuFile = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        menuFile.getItems().addAll(exit);
        this.getMenus().addAll(menuFile);
    }
}
