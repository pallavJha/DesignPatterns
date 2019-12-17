package pl.hfdp.factory.stage1;

import java.util.Arrays;

/**
 * Chocolate Milk Shake is a type of Milk Shake
 */
public class ChocolateMilkShake extends MilkShake {

    /**
     * Adds Chocolate to the MilkShake
     */
    public ChocolateMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Chocolate");
    }

    /**
     * @return name of the Shake that this class is preparing
     */
    public static String name() {
        return "Chocolate Milk Shake";
    }
}
