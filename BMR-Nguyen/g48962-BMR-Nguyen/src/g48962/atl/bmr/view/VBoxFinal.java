package g48962.atl.bmr.view;

import g48962.atl.bmr.model.Person;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import g48962.atl.bmr.util.Observer;
import javafx.scene.chart.XYChart;

/**
 * This is the class of VBoxFinal.
 *
 * @author Michel
 */
public class VBoxFinal extends VBox implements Observer {

    private Button bBMRCalculation;
    private Button bClear;
    private MenuBarBMR menuBar;
    private ErrorAlertData errorAlert;
    private Person person;
    private MenuChart menuChart;
    private Data gridPane1;
    private Result gridPane2;
    private HBox hbox;

    /**
     * This is the contructor of VBoxFinal.
     */
    public VBoxFinal() {
        mainVBox();
    }

    /**
     * This is the main method of the VBoxFinal.
     */
    public void mainVBox() {
        hbox = new HBox();
        gridPane1 = new Data();
        gridPane2 = new Result();
        menuBar = new MenuBarBMR();
        getChildren().add(menuBar);
        person = new Person();
        person.addObserver(this);

        menuChart = new MenuChart();
        hbox.getChildren().addAll(gridPane1, gridPane2, menuChart);
        bBMRCalculation = new Button("Calcul du BMR");
        bClear = new Button("Clear");
        DropShadow shadow = new DropShadow();
        bBMRCalculation.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!gridPane1.getAge().getText().isEmpty() && !gridPane1.getWeight().getText().isEmpty()
                        && !gridPane1.getHeightt().getText().isEmpty()) {
                    bBMRCalculation.setEffect(shadow);
                }
            }
        });

        bBMRCalculation.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bBMRCalculation.setEffect(null);
            }
        });
        resultError();
    }

    /**
     * This method allows to displays the result when there is an error.
     */
    public void resultError() {
        bBMRCalculation.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!gridPane1.getAge().getText().isEmpty() && !gridPane1.getWeight().getText().isEmpty()
                        && !gridPane1.getHeightt().getText().isEmpty()) {
                    try {
                        gridPane2.getBMR().setStyle("-fx-text-inner-color: black;");
                        gridPane2.getCalories().setStyle("-fx-text-inner-color: black;");
                        gridCalculation();
                        putPointToGraph(Integer.parseInt(gridPane1.getHeightt().getText()),
                                Integer.parseInt(gridPane1.getWeight().getText()),
                                Double.parseDouble(gridPane2.getBMR().getText()),
                                Double.parseDouble(gridPane2.getCalories().getText()));
                    } catch (NumberFormatException nfe) {
                        invalidData();
                        errorAlert = new ErrorAlertData(Alert.AlertType.ERROR);
                    }
                } else {
                    incompleteData();
                    errorAlert = new ErrorAlertData(Alert.AlertType.ERROR);
                }
            }
        });

        bClear.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gridPane1.getHeightt().setText("");
                gridPane1.getWeight().setText("");
                gridPane1.getAge().setText("");
                gridPane1.getRbMan().setSelected(true);
                gridPane1.getCbLifeStyle().getSelectionModel().selectFirst();
                gridPane2.getBMR().setText("");
                gridPane2.getCalories().setText("");
                menuChart.getgBmr().getSegmentMen().getData().clear();
                menuChart.getgBmr().getSegmentWomen().getData().clear();
                menuChart.getgCalories().getSegmentMen().getData().clear();
                menuChart.getgCalories().getSegmentWomen().getData().clear();
                menuChart.getgBmrHeight().getSegmentMen().getData().clear();
                menuChart.getgBmrHeight().getSegmentWomen().getData().clear();
            }
        });
        buttonPositionning();
    }

    /**
     * This method allows to calculate the BMR from the two grid panes.
     *
     */
    public void gridCalculation() {
        double bmr;
        bmr = 0;
        if (gridPane1.getRbMan().isSelected()) {
            person.set(Double.parseDouble(gridPane1.getHeightt().getText()),
                    Double.parseDouble(gridPane1.getWeight().getText()),
                    Integer.parseInt(gridPane1.getAge().getText()), true, gridPane1.getCbLifeStyle().getValue());
        } else if (gridPane1.getRbWoman().isSelected()) {
            person.set(Double.parseDouble(gridPane1.getHeightt().getText()),
                    Double.parseDouble(gridPane1.getWeight().getText()),
                    Integer.parseInt(gridPane1.getAge().getText()), false, gridPane1.getCbLifeStyle().getValue());
        }
    }

    /**
     * This method allows to display the invalid Data.
     */
    public void invalidData() {
        gridPane2.getBMR().setText("Données invalides");
        gridPane2.getBMR().setStyle("-fx-text-inner-color: red;");
        gridPane2.getCalories().setText("Données invalides");
        gridPane2.getCalories().setStyle("-fx-text-inner-color: red;");
    }

    /**
     * This method allows to display the incomplete Data.
     */
    public void incompleteData() {
        gridPane2.getBMR().setText("Données incomplètes");
        gridPane2.getBMR().setStyle("-fx-text-inner-color: red;");
        gridPane2.getCalories().setText("Données incomplètes");
        gridPane2.getCalories().setStyle("-fx-text-inner-color: red;");
    }

    /**
     * This method allows to put the buttons positionning in the vbox.
     */
    public void buttonPositionning() {
        bBMRCalculation.setMinWidth(450);
        bBMRCalculation.setAlignment(Pos.BOTTOM_CENTER);
        bClear.setMinWidth(450);
        bClear.setAlignment(Pos.BOTTOM_CENTER);
        getChildren().add(hbox);
        getChildren().add(bBMRCalculation);
        getChildren().add(bClear);

        setSpacing(10);
        setPadding(new Insets(0, 0, 10, 0));
    }

    /**
     * This method allows to put a point on a graph.
     *
     * @param height is the height.
     * @param weight is the weight.
     * @param bmr is the BMR.
     * @param calories is the Calories.
     */
    public void putPointToGraph(int height, int weight, double bmr, double calories) {
        if (gridPane1.getRbMan().isSelected()) {
            menuChart.getgBmr().getSegmentMen().getData().add(new XYChart.Data<>((Number) weight, (Number) bmr));
            menuChart.getgCalories().getSegmentMen().getData().add(new XYChart.Data<>((Number) weight, (Number) calories));
            menuChart.getgBmrHeight().getSegmentMen().getData().add(new XYChart.Data<>((Number) height, (Number) bmr));
        } else {
            menuChart.getgBmr().getSegmentWomen().getData().add(new XYChart.Data<>((Number) weight, (Number) bmr));
            menuChart.getgCalories().getSegmentWomen().getData().add(new XYChart.Data<>((Number) weight, (Number) calories));
            menuChart.getgBmrHeight().getSegmentWomen().getData().add(new XYChart.Data<>((Number) height, (Number) bmr));
        }
    }

    /**
     * This method allows to update a person.
     */
    @Override
    public void update() {
        System.out.println("fdfdsfsdg");
        gridPane2.setBMR(person.getBMR());
        gridPane2.setCalories(person.getCalories());
    }
}
