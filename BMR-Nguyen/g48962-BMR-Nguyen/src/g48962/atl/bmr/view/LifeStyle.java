package g48962.atl.bmr.view;

/**
 * This is the enumeration of a human's life style
 *
 * @author Michel
 */
public enum LifeStyle {

    /**
     * It means if you are sedentary one.
     */
    SEDENTARY("Sédentaire", 1.2),
    /**
     * It means if you are a low active one.
     */
    LOW_ACTIVE("Peu actif", 1.375),
    /**
     * It means if you are an active one.
     */
    ACTIVE("Actif", 1.55),
    /**
     * It means if you are a very active one.
     */
    VERY_ACTIVE("Fort actif", 1.725),
    /**
     * It means if you are an extremely active one.
     */
    EXTREMELY_ACTIVE("Extrêmement actif", 1.9);

    private String translation;
    private double value;

    /**
     * This is the contructor of LifeStyle.
     */
    LifeStyle(String translation, double value) {
        this.translation = translation;
        this.value = value;
    }

    /**
     * This is the Translation's getter.
     *
     * @return the translation in french.
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * This is the Value's getter.
     *
     * @return the value of the level acticity.
     */
    public double getValueLifeStyle() {
        return value;
    }

    /**
     * This is the Translation's setter.
     *
     * @param translation is the translation.
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    /**
     * This is the Value's seteer.
     *
     * @param value is the value of the level acticity.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * This is the method toString of translation.
     *
     * @return the translation in french.
     */
    @Override
    public String toString() {
        return translation;
    }

}
