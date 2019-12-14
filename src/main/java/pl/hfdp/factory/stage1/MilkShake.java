package pl.hfdp.factory.stage1;

import java.util.Collections;
import java.util.List;

public abstract class MilkShake {
    List<String> ingredients = Collections.singletonList("Milk");

    public void addMilk() {
        System.out.println("Adding the milk...");
    }

    public void addIngredients() {
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
