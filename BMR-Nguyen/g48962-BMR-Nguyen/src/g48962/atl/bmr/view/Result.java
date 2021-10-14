package g48962.atl.bmr.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * This is the class of Result.
 *
 * @author Michel
 */
public class Result extends GridPane {

    private TextField BMR;
    private TextField calories;

    /**
     * This is the constructor of Result.
     */
    public Result() {
        edges();
        lblBMR();
        lblCalories();
    }

    /**
     * This methid allows to put the edges in the Grid Pane.
     */
    public void edges() {
        setAlignment(Pos.TOP_RIGHT);
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(5);
        Text resultText = new Text("Résultats");
        resultText.setUnderline(true);
        add(resultText, 0, 0);
    }

    /**
     * This method allows to displays the BMR label and his text field.
     */
    public void lblBMR() {
        Label lblBMR = new Label("BMR");
        setHalignment(lblBMR, HPos.LEFT);
        add(lblBMR, 0, 1);
        BMR = new TextField();
        BMR.setPromptText("Résultats du BMR");
        BMR.setEditable(false);
        BMR.setPrefColumnCount(11);
        add(BMR, 1, 1);
    }

    /**
     * This method allows to displays the Calories label and his text field.
     */
    public void lblCalories() {
        Label lblCalories = new Label("Calories");
        setHalignment(lblCalories, HPos.LEFT);
        add(lblCalories, 0, 2);
        calories = new TextField();
        calories.setPromptText("Dépense en calories");
        calories.setEditable(false);
        calories.setPrefColumnCount(11);
        add(calories, 1, 2);
        getChildren().addAll();
    }

    /**
     * This is the getter of BMR.
     *
     * @return the text field.
     */
    public TextField getBMR() {
        return BMR;
    }

    /**
     * This is the setter of BMR.
     *
     * @param BMRValue is the BMR value.
     */
    public void setBMR(double BMRValue) {
        this.BMR.setText(BMRValue+"");
    }

    /**
     * This is the getter of calories.
     *
     * @return the text field.
     */
    public TextField getCalories() {
        return calories;
    }

    /**
     * This is the setter of Calories.
     * @param caloriesValue
     */
    public void setCalories(double caloriesValue) {
        this.calories.setText(caloriesValue+"");
    }
}
