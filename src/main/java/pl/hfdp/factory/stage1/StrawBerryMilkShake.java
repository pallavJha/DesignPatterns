package pl.hfdp.factory.stage1;

import java.util.Arrays;

/**
 * Strawberry Milk Shake is a type of Milk Shake
 */
public class StrawBerryMilkShake extends MilkShake {

    /**
     * Adds Strawberry to the MilkShake
     */
    public StrawBerryMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Straw Berry");
    }

    /**
     * @return name of the Shake that this class is preparing
     */
    public static String name() {
        return "Strawberry Milk Shake";
    }
}
