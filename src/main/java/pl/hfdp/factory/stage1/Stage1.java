package pl.hfdp.factory.stage1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


abstract class MilkShake {
    List<String> ingredients = Collections.singletonList("Milk");

    void addMilk() {
        System.out.println("Adding the milk...");
    }

    void addIngredients() {
        System.out.println("Adding the ingredients... " + ingredients.toString());
    }

    public void blend() {
        System.out.println("Blending... " + ingredients.toString());
    }

    public String toString() {
        return "MilkShake{" +
                "ingredients=" + ingredients +
                '}';
    }
}

class StrawBerryMilkShake extends MilkShake {

    StrawBerryMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Straw Berry");
    }

    static String name() {
        return "Strawberry Milk Shake";
    }
}

class ChocolateMilkShake extends MilkShake {

    ChocolateMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Chocolate");
    }

    static String name() {
        return "Chocolate Milk Shake";
    }
}

class BananaMilkShake extends MilkShake {

    BananaMilkShake() {
        this.ingredients = Arrays.asList("Milk", "Banana");
    }

    static String name() {
        return "Banana Milk Shake";
    }
}

class MilkShakeFactory {

    public MilkShake orderShake(String type) {
        MilkShake milkShake;

        if (StrawBerryMilkShake.name().equals(type)) {
            milkShake = new StrawBerryMilkShake();
        } else if (ChocolateMilkShake.name().equals(type)) {
            milkShake = new ChocolateMilkShake();
        } else if (BananaMilkShake.name().equals(type)) {
            milkShake = new BananaMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}

public class Stage1 {
    public static void main(String[] args) {
        MilkShakeFactory milkShakeFactory = new MilkShakeFactory();
        MilkShake strawBerryMilkShake = milkShakeFactory.orderShake(StrawBerryMilkShake.name());
        System.out.println(strawBerryMilkShake);
    }
}

