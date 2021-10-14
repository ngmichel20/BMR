package g48962.atl.bmr.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This is the class of ErrorAlertData.
 *
 * @author Michel
 */
public class ErrorAlertData extends Alert {

    /**
     * This is the constructor of ErrorAlertData.
     *
     * @param alertType is the alertData.
     */
    public ErrorAlertData(AlertType alertType) {
        super(alertType);
        Alert alert = new Alert(alertType);
        alert.setTitle("Erreur d'alerte");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir correctement les données.");
        alert.showAndWait();
    }

}
