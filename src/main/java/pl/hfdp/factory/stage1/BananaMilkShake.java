package pl.hfdp.factory.stage1;

import java.util.Arrays;

public class BananaMilkShake extends MilkShake {

    public BananaMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Banana");
    }

    public static String name() {
        return "Banana Milk Shake";
    }
}
