package g48962.atl.bmr.util;

/**
 * This is the interface observable.
 * 
 * @author g48962
 */
public interface Observable {

    /**
     * This method allows to add an Observer.
     * 
     * @param obs is an Observer.
     */
    void addObserver(Observer obs);

    /**
     * This method allows to remove an Observer. 
     * 
     * @param obs is an Observer.
     */
    void removeObserver(Observer obs);
}
