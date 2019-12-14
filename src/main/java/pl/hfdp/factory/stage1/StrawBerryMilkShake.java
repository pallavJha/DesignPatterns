package pl.hfdp.factory.stage1;

import java.util.Arrays;

public class StrawBerryMilkShake extends MilkShake {

    public StrawBerryMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Straw Berry");
    }

    public static String name() {
        return "Strawberry Milk Shake";
    }
}
