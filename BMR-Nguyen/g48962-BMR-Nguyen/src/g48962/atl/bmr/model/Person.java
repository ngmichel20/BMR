package g48962.atl.bmr.model;

import java.util.ArrayList;
import java.util.List;
import g48962.atl.bmr.util.Observable;
import g48962.atl.bmr.util.Observer;
import g48962.atl.bmr.view.VBoxFinal;
import g48962.atl.bmr.view.Data;
import g48962.atl.bmr.view.LifeStyle;
import g48962.atl.bmr.view.Result;

/**
 * This is the class Person.
 *
 * @author g48962
 */
public class Person implements Observable {

    private double height;
    private double weight;
    private int age;
    private boolean gender;
    private List<Observer> observers = new ArrayList<>();
    private VBoxFinal vBoxFinal;
    private Result gridPane2;
    private Data gridPane1;
    private LifeStyle lifeStyle;

    /**
     * This method allows to set the person.
     *
     * @param height is the height.
     * @param weight is the weight.
     * @param age is the age.
     * @param gender is the gender.
     * @param lifeStyle is the lifestyle.
     */
    public void set(double height, double weight, int age, boolean gender, LifeStyle lifeStyle) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender; //if true = Man else Woman.
        this.lifeStyle = lifeStyle;
        notifyObservers();
    }

    /**
     * This is the getter of the person's BMR.
     *
     * @return the BMR.
     */
    public double getBMR() {
        if (gender) {
            return calculationBMRMan(weight, height, age);
        } else {
            return calculationBMRWoman(weight, height, age);
        }
    }

    /**
     * This is the getter of the person's calories.
     *
     * @return the calories.
     */
    public double getCalories() {
        return getBMR() * lifeStyle.getValueLifeStyle();
    }

    /**
     * This method allows to calculate the BMR of a man.
     *
     * @param weight is the weight.
     * @param height is the height.
     * @param age is the age.
     * @return the BMR.
     */
    public double calculationBMRMan(double weight, double height, double age) {
        return 13.7 * weight + 5 * height - 6.8 * age + 66;
    }

    /**
     * This method allows to calculate the BMR of a woman.
     *
     * @param weight is the weight.
     * @param height is the height.
     * @param age is the age.
     * @return the BMR.
     */
    public double calculationBMRWoman(double weight, double height, double age) {
        return 9.6 * weight + 1.8 * height - 4.7 * age + 655;
    }

    /**
     * This method allows to notify all the Observers.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * This method allows to add an Observer.
     *
     * @param obs is an Observer.
     */
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * This method allows to remove an Observer.
     *
     * @param obs is an Observer.
     */
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }
}
