package g48962.atl.bmr.view;

import javafx.scene.control.TextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * This is the Data's class.
 *
 * @author g48962
 */
public class Data extends GridPane {

    private TextField height;
    private TextField age;
    private TextField weight;
    private RadioButton rbWoman;
    private RadioButton rbMan;
    private ChoiceBox<LifeStyle> cbLifeStyle;

    /**
     * This is the contructor Data.
     */
    public Data() {
        edges();
        dataText();
        lblHeight();
        lblWeight();
        lblAge();
        lblGender();
        toggleGrpGender();
        lblLifeStyle();
    }

    /**
     * This methid allows to put all the edges in the box.
     */
    public void edges() {
        setAlignment(Pos.TOP_LEFT);
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(5);
    }

    /**
     * This method displays the title "Données".
     */
    public void dataText() {
        Text dataText = new Text("Données");
        dataText.setUnderline(true);
        add(dataText, 0, 0);
    }

    /**
     * This method displays the height's label and his Text Field.
     */
    public void lblHeight() {
        Label lblHeight = new Label("Taille(cm)");
        GridPane.setHalignment(lblHeight, HPos.LEFT);
        add(lblHeight, 0, 1);
        height = new TextField();
        height.setPromptText("Taille en cm");
        height.setPrefColumnCount(5);
        add(height, 1, 1);
    }

    /**
     * This method displays the weight's label and his Text Field.
     */
    public void lblWeight() {
        Label lblWeight = new Label("Poids(kg)");
        GridPane.setHalignment(lblWeight, HPos.LEFT);
        add(lblWeight, 0, 2);
        weight = new TextField();
        weight.setPromptText("Poids en kg");
        weight.setPrefColumnCount(5);
        add(weight, 1, 2);
    }

    /**
     * This method displays the age's label and his Text Field.
     */
    public void lblAge() {
        Label lblAge = new Label("Âge(années)");
        GridPane.setHalignment(lblAge, HPos.LEFT);
        add(lblAge, 0, 3);
        age = new TextField();
        age.setPromptText("Âge en années");
        age.setPrefColumnCount(5);
        add(age, 1, 3);
    }

    /**
     * This method displays the gender's label and his Text Field.
     */
    public void lblGender() {
        Label lblGender = new Label("Sexe");
        GridPane.setHalignment(lblGender, HPos.LEFT);
        add(lblGender, 0, 4);
    }

    /**
     * This method displays the Toggle Group and the radio button.
     */
    public void toggleGrpGender() {
        ToggleGroup gender = new ToggleGroup();
        rbMan = new RadioButton("Homme");
        rbWoman = new RadioButton("Femme");
        GridPane.setHalignment(rbMan, HPos.LEFT);
        GridPane.setHalignment(rbWoman, HPos.RIGHT);
        rbMan.setToggleGroup(gender);
        rbMan.setSelected(true);
        rbWoman.setToggleGroup(gender);
        add(rbMan, 1, 4);
        add(rbWoman, 1, 4);
    }

    /**
     * This method displays the choice box.
     */
    public void lblLifeStyle() {
        Label lblLifeStyle = new Label("Style de vie");
        GridPane.setHalignment(lblLifeStyle, HPos.LEFT);
        add(lblLifeStyle, 0, 5);
        cbLifeStyle = new ChoiceBox<>();
        cbLifeStyle.getItems().addAll(LifeStyle.values());
        cbLifeStyle.getSelectionModel().selectFirst();
        add(cbLifeStyle, 1, 5);
        getChildren().addAll();
    }

    /**
     * This is the getter of height.
     *
     * @return the text field.
     */
    public TextField getHeightt() {
        return height;
    }

    /**
     * This is the setter of height.
     *
     * @param height the height.
     */
    public void setHeight(TextField height) {
        this.height = height;
    }

    /**
     * This is the getter of Age.
     *
     * @return the text field.
     */
    public TextField getAge() {
        return age;
    }

    /**
     * This is the setter of Age.
     *
     * @param age is the age.
     */
    public void setAge(TextField age) {
        this.age = age;
    }

    /**
     * This is the getter of Weight.
     *
     * @return the text field.
     */
    public TextField getWeight() {
        return weight;
    }

    /**
     * This is the setter of weight.
     *
     * @param weight is the weight.
     */
    public void setWeight(TextField weight) {
        this.weight = weight;
    }

    /**
     * This is the getter of rbWoman.
     *
     * @return the radio button.
     */
    public RadioButton getRbWoman() {
        return rbWoman;
    }

    /**
     * This is the setter of rbWoman.
     *
     * @param rbWoman is the radio button.
     */
    public void setRbWoman(RadioButton rbWoman) {
        this.rbWoman = rbWoman;
    }

    /**
     * This is the getter of rbMan.
     *
     * @return the radio Button.
     */
    public RadioButton getRbMan() {
        return rbMan;
    }

    /**
     * This is the setter of rbMan.
     *
     * @param rbMan is the radiot button.
     */
    public void setRbMan(RadioButton rbMan) {
        this.rbMan = rbMan;
    }

    /**
     * This is the getter of cbLifeStyle.
     *
     * @return the choice box.
     */
    public ChoiceBox<LifeStyle> getCbLifeStyle() {
        return cbLifeStyle;
    }

    /**
     * This is the setter of cbLifeStyle.
     *
     * @param cbLifeStyle is the choicebox.
     */
    public void setCbLifeStyle(ChoiceBox<LifeStyle> cbLifeStyle) {
        this.cbLifeStyle = cbLifeStyle;
    }

}
