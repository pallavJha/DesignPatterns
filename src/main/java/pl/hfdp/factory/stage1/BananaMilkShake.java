package pl.hfdp.factory.stage1;

import java.util.Arrays;

/**
 * Banana Milk Shake is type of a Milk Shake.
 */
public class BananaMilkShake extends MilkShake {

    /**
     * Add banana to the ingredients
     */
    public BananaMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Banana");
    }

    /**
     * @return name of the Shake that this class is preparing
     */
    public static String name() {
        return "Banana Milk Shake";
    }
}
