package am.itspace.java8.service;


public interface Vehicle {

    /**
     * Gets brand.
     *
     * @return the brand
     */
    String getBrand();

    /**
     * Speed up string.
     *
     * @return the string
     */
    String speedUp();

    /**
     * Slow down string.
     *
     * @return the string
     */
    String slowDown();

    /**
     * Turn alarm on string.
     *
     * @return the string
     */
    default String turnAlarmOn() {
        return "Turning the vehice alarm on.";
    }

    /**
     * Turn alarm off string.
     *
     * @return the string
     */
    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }

    /**
     * Gets horse power.
     *
     * @param rpm    the rpm
     * @param torque the torque
     * @return the horse power
     */
    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }

}