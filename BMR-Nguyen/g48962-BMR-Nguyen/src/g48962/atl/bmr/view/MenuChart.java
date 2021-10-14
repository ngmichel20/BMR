package g48962.atl.bmr.view;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * The menu who contains all charts.
 *
 * @author Michel
 */
public class MenuChart extends TabPane  {

    /**
     * The chart who represent the weight and the BMR
     */
    BMRWeightChart bmrWC;
    /**
     * The chart who reprensent the weigth and the calories
     */
    CaloriesWeightChart caloriesWC;
    /**
     * The chart who represent the Height and the BMR
     */
    BMRHeigthChart bmrHC;
    /**
     * Inialize the attributs and create the menu with the chart
     */
    public MenuChart() {
        bmrWC = new BMRWeightChart();
        caloriesWC = new CaloriesWeightChart();
        bmrHC = new BMRHeigthChart();

        Tab tab = new Tab();
        tab.setText("Weigth(kg) Vs BMR");
        tab.setContent(bmrWC);

        Tab tab2 = new Tab();
        tab2.setText("Weigth(kg) Vs Calories");
        tab2.setContent(caloriesWC);

        Tab tab3 = new Tab();
        tab3.setText("Height (cm) Vs BMR");
        tab3.setContent(bmrHC);
        this.setPadding(new Insets(0, 0, 0, 80));
        this.getTabs().addAll(tab, tab2, tab3);

    }

    /**
     * Give the chart who represent the weight and the BMR
     *
     * @return The chart who represent the weight and the BMR
     */
    public BMRWeightChart getgBmr() {
        return bmrWC;
    }

    /**
     *
     * Give the chart who reprensent the weigth and the calories
     *
     * @return The chart who reprensent the weigth and the calories
     */
    public CaloriesWeightChart getgCalories() {
        return caloriesWC;
    }

    /**
     * Give the chart who represent the Height and the BMR
     *
     * @return The chart who represent the Height and the BMR
     */
    public BMRHeigthChart getgBmrHeight() {
        return bmrHC;
    }
}

